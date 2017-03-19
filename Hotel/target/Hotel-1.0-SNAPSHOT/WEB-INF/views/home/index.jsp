<%-- 
    Document   : index
    Created on : Mar 17, 2017, 5:50:33 AM
    Author     : HYOJU
--%>
<%@include file="../header.jsp" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<title>Hotel Home</title>
</head>
<%@include file="../navbar.jsp" %>


<div id="carousel-example-generic" class="carousel  slide" data-ride="carousel" >
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        <li data-target="#carousel-example-generic" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox"  >
        <div class="item active" style="background-image:url(${SITE_URL}/static/image/frontpool.jpg);height:500px;background-repeat:no-repeat;background-position:center;background-size:cover">
        </div>
        <div class="item" style="background-image:url(${SITE_URL}/static/image/suite.jpg);height:500px;background-repeat:no-repeat;background-position: center;background-size:cover">
        </div>
        <div class="item" style="background-image:url(${SITE_URL}/static/image/allroom.jpg);height:500px;background-repeat:no-repeat;background-position: center;background-size:cover">
        </div>
        <div class="item" style="background-image:url(${SITE_URL}/static/image/lounge.jpg);height:500px;background-repeat:no-repeat;background-position: center;background-size:cover">
        </div>
    </div>
    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<div class="container text-center">    
    <h3>LUCRATIVE NEW OFFERS & GIVEAWAYS</h3><br>
    <div class="row">
        <div class="col-sm-4">
            <img src="${SITE_URL}/static/image/offer.jpg" class="img-responsive" style="width:100%" alt="Image">
        </div>
        <div class="col-sm-4"> 
            <img src="${SITE_URL}/static/image/winteroffer.jpg" class="img-responsive" style="width:100%" alt="Image">
        </div>
        <div class="col-sm-4">
            <img src="${SITE_URL}/static/image/deals.jpg" class="img-responsive" style="width:100%" alt="Image">
        </div>
    </div><br>
</div>
    <%@include file="../footer2.jsp" %>
