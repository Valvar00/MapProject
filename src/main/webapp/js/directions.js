
let myArray = ['red', 'green', 'yellow' , 'orange'];
const key ="AIzaSyC4Ol2D6liSWpNo35RyV8kiqbePec_Bh0w";
function initMap() {
    var markerArray = [];
    var coordinates_start = {lat: 51.109, lng: 17.06};
    var coordinates_end = {lat: 51.109782, lng:17.0322};
    var directionsService = new google.maps.DirectionsService;
    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 13,
        center: {lat: 51.109, lng: 17.06}
    });
    var directionsRenderer = new google.maps.DirectionsRenderer({map: map, alternatives: true
    });

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

    var onChangeHandler = function() {
        calculateAndDisplayRoute(
            directionsRenderer, directionsService, markerArray, map , start_marker , end_marker);
    };
    document.getElementById('button').addEventListener('click', onChangeHandler);
}

function calculateAndDisplayRoute(directionsRenderer, directionsService,
                                  markerArray,  map ,st_marker , en_marker) {
    if (st_marker!=undefined){
        for (var i = 0; i < markerArray.length; i++) {
            markerArray[i].setMap(null);
        }
        var stlat = st_marker.position.lat();

        var stlng = st_marker.position.lng();
        var enlat = en_marker.position.lat();
        var enlng = en_marker.position.lng();
        var distance = google.maps.geometry.spherical.computeDistanceBetween(new google.maps.LatLng(stlat,stlng),new google.maps.LatLng(enlat,enlng));
         let url = `https://maps.googleapis.com/maps/api/geocode/json?latlng=${stlat},${stlng}&key=${key}`;
      fetch(url)
        .then(response => response.json())
        .then(data => {
          console.log(data);
          let parts = data.results[0].address_components;
          document.body.insertAdjacentHTML(
            "beforeend",
            `<p>Formatted: ${data.results[0].formatted_address}</p>`
          );
          parts.forEach(part => {
            if (part.types.includes("country")) {
              //we found "country" inside the data.results[0].address_components[x].types array
              document.body.insertAdjacentHTML(
                "beforeend",
                `<p>COUNTRY: ${part.long_name}</p>`
              );
            }
            if (part.types.includes("administrative_area_level_1")) {
              document.body.insertAdjacentHTML(
                "beforeend",
                `<p>PROVINCE: ${part.long_name}</p>`
              );
            }
            if (part.types.includes("administrative_area_level_3")) {
              document.body.insertAdjacentHTML(
                "beforeend",
                `<p>LEVEL 3: ${part.long_name}</p>`
              );
            }
          });
        })
        .catch(err => console.warn(err.message));
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
            } else {
                window.alert('Directions request failed due to ' + status);
            }
        });
    }
}



