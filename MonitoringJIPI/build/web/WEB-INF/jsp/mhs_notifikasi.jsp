<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>MONITORING TA/SKRIPSI</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/datepicker3.css" rel="stylesheet">
        <link href="css/styles.css" rel="stylesheet">

        <!--Icons-->
        <script src="js/lumino.glyphs.js"></script>

        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->

    </head>

    <body>


    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#"><span>APLIKASI MONITORING PENYUSUNAN TUGAS AKHIR/SKRIPSI</span> UNIVERSITAS NASIONAL PASIM</a>
                <ul class="user-menu">
                    <li class="dropdown pull-right">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> ${dto.namamahasiswa} <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> Profile</a></li>
                            <li><a href="#"><svg class="glyph stroked gear"><use xlink:href="#stroked-gear"></use></svg> Settings</a></li>
                            <li><a href="#"><svg class="glyph stroked cancel"><use xlink:href="#stroked-cancel"></use></svg> Logout</a></li>
                        </ul>
                    </li>
                </ul>
            </div>

        </div><!-- /.container-fluid -->
    </nav>
    <!--//////////////////////////////// menu bar samping kiri //////////////////////////////	-->
    <div id="sidebar-collapse" class="col-sm-7 col-lg-2 sidebar">

        <c:url var="panggilProfil" value="/mhs_profil.htm">
            <c:param name="nim" value="${dto.nim}" />
        </c:url>
        <c:url var="panggilNotif" value="/mhs_notifikasi.htm">
            <c:param name="nim" value="${dto.nim}" />
        </c:url>
        <c:url var="panggilBerandaAlumni" value="/berandaalumni.htm">
            <c:param name="nim" value="${dto.nim}" />
        </c:url>
        <c:url var="panggilIndex" value="/mhs_index.htm">
            <c:param name="nim" value="${dto.nim}" />
        </c:url>
        <ul class="nav menu">

            <li><a href="${panggilIndex}"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-dashboard-dial"></use></svg> Home Mahasiswa</a></li>
            <li><a href="${panggilProfil}"><svg class="glyph stroked calendar"><use xlink:href="#stroked-calendar"></use></svg> Profil</a></li>
            <li class="active"><a href="${panggilNotif}"><svg class="glyph stroked line-graph"><use xlink:href="#stroked-line-graph"></use></svg> Notifikasi</a></li>
            <li><a href="${panggilBerandaAlumni}"><svg class="glyph stroked table"><use xlink:href="#stroked-table"></use></svg> Beranda Alumni</a></li>
            <li role="presentation" class="divider"></li>

        </ul>

    </div><!--/.sidebar-->

    <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
        <div class="row">
            <ol class="breadcrumb">
                <li><a href="mhs_index.htm"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
                <li class="active">Home</li>
            </ol>
        </div><!--/.row-->
        <div class="row">
            <div class="col-lg-12">
                <h2>Notifikasi</h2>
            </div>
            <div class="panel-body">
                <%--<c:set var="index" value="1"/>--%>
                <c:forEach var="list" items="${listNotif}">
                    <c:url var="openeditnotif" value="/openAndEditNotif.htm">
                        <c:param name="nim" value="${dto.nim}"/>
                        <c:param name="kdnotif" value="${list.kdnotif}"/>
                    </c:url>
                    <a href="${openeditnotif}">
                        <div class="col-md-12">
                            <div class="panel ${list.statusbaca}">
                                <div class="panel-heading dark-overlay" style="color: gray">${list.subjeknotif}</div>
                                <div class="panel-body">
                                    <p>${list.tglnotif}</p>
                                    <p>${list.judulnotif}</p>
                                    <c:url var="hapusnotif" value="/hapusnotif.htm">
                                        <c:param name="nim" value="${dto.nim}"/>
                                        <c:param name="kdnotif" value="${list.kdnotif}"/>
                                    </c:url>
                                    <div align="right" ><a href="${hapusnotif}"><p>X</p></a></div>
                                </div>
                            </div>
                        </div>
                    </a>

                    <%--  <c:set var="index" value="${index+1}"/>--%>
                </c:forEach>
            </div>












        </div><!--/.row-->	


        <div class="row">

        </div><!--/.row-->

        <div class="row">

        </div><!--/.row-->
    </div>	<!--/.main-->

    <script src="js/jquery-1.11.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/chart.min.js"></script>
    <script src="js/chart-data.js"></script>
    <script src="js/easypiechart.js"></script>
    <script src="js/easypiechart-data.js"></script>
    <script src="js/bootstrap-datepicker.js"></script>
    <script>
        $('#calendar').datepicker({
        });

        !function ($) {
            $(document).on("click", "ul.nav li.parent > a > span.icon", function () {
                $(this).find('em:first').toggleClass("glyphicon-minus");
            });
            $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
        }(window.jQuery);

        $(window).on('resize', function () {
            if ($(window).width() > 768)
                $('#sidebar-collapse').collapse('show')
        })
        $(window).on('resize', function () {
            if ($(window).width() <= 767)
                $('#sidebar-collapse').collapse('hide')
        })
    </script>	
</body>

</html>

