<%-- 
    Document   : carousel
    Created on : Mar 17, 2017, 6:02:30 AM
    Author     : HYOJU
--%>

<body style="background-image: url(${SITE_URL}/static/image/back.jpg); background-size:cover">
    <nav class="navbar navbar-inverse"  style="margin-bottom:0px;">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">HAVOC Hotel</a>
            </div>
            <ul class="nav navbar-nav">
                <li> <a href="${SITE_URL}">Home</a></li>
                <li><a href="${SITE_URL}/admin/room">Room</a></li>
                <li><a href="${SITE_URL}/admin/booking">Booking</a></li>
                <li><a href="${SITE_URL}/admin/comments">Comments</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${SITE_URL}/admin/checkin/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
            </ul>
        </div>
    </nav>