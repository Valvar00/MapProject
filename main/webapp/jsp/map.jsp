<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <title>Directions Service (Complex)</title>
    <link rel="stylesheet" type="text/css" href="../css/map_styles.css">

</head>
<body>
<div>
    <p>Drag points on map to show Start and End points of a route</p>
    <p id='result'></p>
</div>
<input id="button" type="submit" name="button" class="btn btn2"  value="Create route"/>
<div id="map"></div>
<div id="warnings-panel"></div>
<script src="../js/directions.js"></script>
<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?libraries=geometry&sensor=false"></script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC4Ol2D6liSWpNo35RyV8kiqbePec_Bh0w&callback=initMap">
</script>
</body>
</html>