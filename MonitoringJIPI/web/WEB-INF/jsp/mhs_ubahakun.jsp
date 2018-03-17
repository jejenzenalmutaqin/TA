<%-- 
    Document   : mhs_ubahakun
    Created on : Jan 21, 2018, 8:07:55 PM
    Author     : HP
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
>
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
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> Akademik <span class="caret"></span></a>
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
		
		<ul class="nav menu">
			<li><a href="mhs_index.htm"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-dashboard-dial"></use></svg> Home Mahasiswa</a></li>
			<li class="active"><a href="mhs_profil.htm"><svg class="glyph stroked calendar"><use xlink:href="#stroked-calendar"></use></svg> Profil</a></li>
			<li><a href="mhs_notifikasi.htm"><svg class="glyph stroked line-graph"><use xlink:href="#stroked-line-graph"></use></svg> Notifikasi</a></li>
			<li><a href="berandaalumni.htm"><svg class="glyph stroked table"><use xlink:href="#stroked-table"></use></svg> Beranda Alumni</a></li>
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
		<center>
               <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Ubah Akun</h1>

                </div>
               </div>
                    <div class="row">
                    <!-- /////////////////////////////////////////////////////////////-->
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading"> Form Ubah Data Akun</div>
                            <div class="panel-body">
                                <form:form class="form-horizontal" action="#" method="post" modelAttribute="userDto">
                                    <fieldset>
                                        <!-- Kode input-->
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Username</label>
                                            <div class="col-md-9">
                                                <form:input path="username" placeholder="Username" class="form-control"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Password Lama</label>
                                            <div class="col-md-9">
                                                <form:input path="password" placeholder="Password Lama" class="form-control"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Password Baru</label>
                                            <div class="col-md-9">
                                                <form:input path="password" placeholder="Password Baru" class="form-control"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Konnfirmasi Password</label>
                                           <div class="col-md-9">
                                                <form:input path="password" placeholder="Konfirmasi Password" class="form-control"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-md-12 widget-right">
                                                <input type="submit" class="btn btn-default btn-md pull-right" id="sbm" value="Simpan" />
                                            </div>
                                        </div>
                                    </fieldset>
                                </form:form>
                            </div>
                        </div>
                    </div><!--/.col-->
                </div>
                </center>
		
		
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
		    $(document).on("click","ul.nav li.parent > a > span.icon", function(){          
		        $(this).find('em:first').toggleClass("glyphicon-minus");      
		    }); 
		    $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
		}(window.jQuery);

		$(window).on('resize', function () {
		  if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
		})
		$(window).on('resize', function () {
		  if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
		})
	</script>	
</body>

</html>

