
let myArray = ['red', 'green', 'yellow' , 'orange'];

function initMap() {
    var markerArray = [];
    var coordinates_start = {lat: 51.109, lng: 17.06};
    var coordinates_end = {lat: 51.109782, lng:17.0322};
    var directionsService = new google.maps.DirectionsService;
    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 13,
        center: {lat: 51.109, lng: 17.06}
    });
    var directionsRenderer = new google.maps.DirectionsRenderer({map: map
    });
    var stepDisplay = new google.maps.InfoWindow;
    calculateAndDisplayRoute(
        directionsRenderer, directionsService, markerArray, stepDisplay, map);

    var start_marker = new google.maps.Marker({
        position: coordinates_start,
        map: map,
        label: 'A',
        draggable:true,
        title: 'Start Point'
    });

    var end_marker = new google.maps.Marker({
        position: coordinates_end,
        map: map,
        label: 'B',
        draggable:true,
        title: 'End Point'
    });
    var distance = google.maps.geometry.spherical.computeDistanceBetween(new google.maps.LatLng(start_marker.position.lat(),start_marker.position.lng()),new google.maps.LatLng(end_marker.position.lat(),end_marker.position.lng()));
    var onChangeHandler = function() {
        calculateAndDisplayRoute(
            directionsRenderer, directionsService, markerArray, stepDisplay, map , start_marker , end_marker);
    };
    document.getElementById('button').addEventListener('click', onChangeHandler);
}

function calculateAndDisplayRoute(directionsRenderer, directionsService,
                                  markerArray, stepDisplay, map ,st_marker , en_marker) {
    if (st_marker!=undefined){
        for (var i = 0; i < markerArray.length; i++) {
            markerArray[i].setMap(null);
        }
        directionsRenderer.setOptions({
            polylineOptions: {
                strokeColor: myArray[Math.floor(Math.random() * 5)]
            }
        });
        directionsService.route({
            origin: st_marker.position,
            destination: en_marker.position,
            travelMode: 'WALKING'
        }, function(response, status) {
            if (status === 'OK') {
                document.getElementById('warnings-panel').innerHTML =
                    '<b>' + response.routes[0].warnings + '</b>';
                directionsRenderer.setDirections(response);
                showSteps(response, markerArray, stepDisplay, map);
            } else {
                window.alert('Directions request failed due to ' + status);
            }
        });
    }
}

function showSteps(directionResult, markerArray, stepDisplay, map) {
    var myRoute = directionResult.routes[0].legs[0];
    for (var i = 0; i < myRoute.steps.length; i++) {
        var marker = markerArray[i] = markerArray[i] || new google.maps.Marker;
        marker.setMap(map);
        marker.setPosition(myRoute.steps[i].start_location);
        attachInstructionText(
            stepDisplay, marker, myRoute.steps[i].instructions, map);
    }
}

function attachInstructionText(stepDisplay, marker, text, map) {
    google.maps.event.addListener(marker, 'click', function() {
        stepDisplay.setContent(text);
        stepDisplay.open(map, marker);
    });
}