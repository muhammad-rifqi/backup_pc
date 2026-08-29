<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>GPS TRACKING</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
       
    </head>
    <body style="background-color: #ccc">
        <div class="container">
            @if (Route::has('login'))
                <div class="row" style="padding:10px">
                    <div class="col-md-6  text-left">
                    <h3>GPS TRACKING</h3>
                    </div>
                    <div class="col-md-6  text-right">
                       @auth
                            <a href="{{ url('/dashboard/home') }}" class="btn btn-primary">Home</a>
                        @else
                            <a href="{{ route('login') }}" class="btn btn-primary">Login</a>

                            @if (Route::has('register'))
                                <a href="{{ route('register') }}" class="btn btn-primary">Register</a>
                            @endif

                            <a href="#" class="btn btn-primary" data-toggle="modal" data-target="#popUpModal"> Tracking Now</a>
                        @endauth 
                    </div>   
                </div>
            @endif

            <div class="row">
            <div class="col-md-12" style="border-radius: 10px; box-shadow: 5px 5px 5px #000;" id="peta">
            
                <!-- <div id="details"></div> -->
                <!-- map.innerHTML = '<iframe width="700" height="300" src="https://maps.google.com/maps?q='+latitude+','+longitude+'&amp;z=15&amp;output=embed"></iframe>'; -->
            </div>
            </div>
        </div>
    </body>
    <div class="modal fade" id="popUpModal" tabindex="-1" role="dialog" aria-labelledby="popUpModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
        <div class="modal-header">
            <h5 class="modal-title" id="popUpModalLabel">Tracking Dengan Latitude & Longitude</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div class="modal-body">
        <form>
            <div class="form-group row">
                <label for="staticEmail" class="col-sm-2 col-form-label">Latitude</label>
                <div class="col-sm-10">
                <input type="text" class="form-control" id="latitude" placeholder="Latitude">
                </div>
            </div>
            <div class="form-group row">
                <label for="inputPassword" class="col-sm-2 col-form-label">Longitude</label>
                <div class="col-sm-10">
                <input type="text" class="form-control" id="longitude" placeholder="Longitude">
                </div>
            </div>
            </form>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary" id="out" onclick="getValue()">Save changes</button>
        </div>
        </div>
    </div>
    </div>

<script>
    document.getElementById("peta").innerHTML='<iframe src="https://maps.google.com/maps?q=-6.238566989265031,106.78551115626857&hl=en&z=14&amp;output=embed" allowfullscreen="true" style="width:100%; height:700px; border:none;"></iframe>';
    function getValue(){
        var a = document.getElementById("latitude").value;
        var b = document.getElementById("longitude").value;
            document.getElementById("peta").innerHTML='<iframe src="https://maps.google.com/maps?q='+a+','+b+'&hl=en&z=14&amp;output=embed" allowfullscreen="true" style="width:100%; height:700px; border:none;"></iframe>';
            document.getElementById("out").setAttribute("data-dismiss", "modal");
    }
</script>
<!-- <script>


var detail = document.getElementById("detail");

var reqcount = 0;

navigator.geolocation.watchPosition(successCallback, errorCallback, options);

function successCallback(position) {
	const { accuracy, latitude, longitude, altitude, heading, speed } = position.coords;
    reqcount++;
    details.innerHTML = "Accuracy: "+accuracy+"<br>";
    details.innerHTML += "Latitude: "+latitude+" | Longitude: "+longitude+"<br>";
    details.innerHTML += "Altitude: "+altitude+"<br>";
    details.innerHTML += "Heading: "+heading+"<br>";
    details.innerHTML += "Speed: "+speed+"<br>";
    details.innerHTML += "reqcount: "+reqcount;
}
function errorCallback(err) {
	console.warn(`ERROR(${err.code}): ${err.message}`);
}
var options = {
	enableHighAccuracy: false,
	timeout: 5000,
	maximumAge: 0
};
</script> -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</html>
