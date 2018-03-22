
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
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> Dosen <span class="caret"></span></a>
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
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		
		<ul class="nav menu">
			<li class="active"><a href="dsn_index.htm"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-dashboard-dial"></use></svg> Home</a></li>
			<li><a href="dsn_DknViewProposal.htm"><svg class="glyph stroked calendar"><use xlink:href="#stroked-calendar"></use></svg> View Proposal</a></li>
			<li><a href="dsn_DknViewSidang.htm"><svg class="glyph stroked line-graph"><use xlink:href="#stroked-line-graph"></use></svg> View Pengajuan Sidang</a></li>
			<li><a href="dsn_DknViewKelulusan.htm"><svg class="glyph stroked table"><use xlink:href="#stroked-table"></use></svg> View kelulusan</a></li>
			<li><a href="dsn_DknViewAlumni.htm"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg> View Alumni</a></li>
			<li class="parent ">
				<a href="#">
					<span data-toggle="collapse" href="#sub-item-1"><svg class="glyph stroked chevron-down"><use xlink:href="#stroked-chevron-down"></use></svg></span> Laporan 
				</a>
				<ul class="children collapse" id="sub-item-1">
					<li>
						<a class="" href="dsn_DknViewProposal.htm">
							<svg class="glyph stroked chevron-right"><use xlink:href="#stroked-chevron-right"></use></svg> Pengajuan Proposal
						</a>
					</li>
					<li>
						<a class="" href="dsn_DknViewSidang.htm">
							<svg class="glyph stroked chevron-right"><use xlink:href="#stroked-chevron-right"></use></svg> Pengajuan Sidang
						</a>
					</li>
					<li>
						<a class="" href="dsn_DknViewKelulusan.htm">
							<svg class="glyph stroked chevron-right"><use xlink:href="#stroked-chevron-right"></use></svg> Data Kelulusan
						</a>
					</li>
                                        <li>
						<a class="" href="dsn_DknViewAlumni.htm">
							<svg class="glyph stroked chevron-right"><use xlink:href="#stroked-chevron-right"></use></svg> Data Alumni
						</a>
					</li>
				</ul>
			</li>
			<li role="presentation" class="divider"></li>
		</ul>

	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">          
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="akd_index.htm"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
                    <li class="active">Data Alumni</li>
                </ol>
            </div><!--/.row-->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Data Alumni</h1>
                </div>
            </div><!--/.row-->
            
		
		<div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading"> Filter Data Alumni</div>
                            <div class="panel-body">
                        <form:form action="viewAlumni.htm" modelAttribute="dto"  method="POST">    
                        <fieldset>
                            <div class="form-group">
                                <label class="col-md-3 control-label" >Jurusan </label>
                                    <div class="col-md-9">
                                        <form:select path="kdjurusan" class="form-control validate validate[required]">
                                            <form:option value="" selected="true" disabled="true">Jurusan</form:option>
                                                <c:forEach var="prodi" items="${listJurusanDto}">
                                                    <form:option value="${prodi.kdjurusan}">${prodi.namajurusan}</form:option>
                                                </c:forEach>
                                        </form:select>
                                    </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" >Pengelompokan </label>
                                    <div class="col-md-4">
                                            <form:radiobutton path="grouping" value="daerahasal"/>Daerah Asal
                                    </div>
                                    <div class="col-md-4">
                                            <form:radiobutton path="grouping" value="daerahkerja"/>Daerah Tempat Kerja
                                    </div>
                                    <div class="col-md-4">
                                            <form:radiobutton path="grouping" value="sektor"/>Sektor
                                    </div>
                                    <div class="col-md-4">
                                            <form:radiobutton path="grouping" value="profesi"/>Profesi
                                   </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" >Angkatan </label>
                                    <div class="col-md-9">
                                        <form:select path="angkatan">
                                            <form:option value="" selected="true" >Angkatan</form:option>
                                                    <form:option  value="2001" >2001</form:option>
                                                    <form:option  value="2002" >2002</form:option>
                                                    <form:option  value="2003" >2002</form:option>
                                                    <form:option  value="2004" >2004</form:option>
                                                    <form:option  value="2005" >2005</form:option>
                                                    <form:option  value="2006" >2006</form:option>
                                                    <form:option  value="2007" >2007</form:option>
                                                    <form:option  value="2008" >2008</form:option>
                                                    <form:option  value="2009" >2009</form:option>
                                                    <form:option  value="2010" >2010</form:option>
                                                    <form:option  value="2011" >2011</form:option>
                                                    <form:option  value="2012" >2012</form:option>
                                                    <form:option  value="2013" >2013</form:option>
                                                    <form:option  value="2014" >2014</form:option>
                                                    <form:option  value="2015" >2015</form:option>
                                                    <form:option  value="2016" >2016</form:option>
                                                    <form:option  value="2017" >2017</form:option>
                                        </form:select>
                                    </div>
                            </div>
                            <div class="form-group">
                                            <div class="col-md-12 widget-right">
                                                <input type="submit" class="btn btn-primary btn-md pull-right"  id="sbm" value="Simpan" />
                                            </div>
                            </div>
                        </fieldset>
                                <form:hidden path="nim"/>
                                <form:hidden path="namamahasiswa"/>
                                <form:hidden path="alamatperusahaan"/>
                                <form:hidden path="ipk"/>
                                <form:hidden path="sektor"/>
                                <form:hidden path="profesi"/>
                                <form:hidden path="namafakultas"/>
                                <form:hidden path="kdfakultas"/>
                        </form:form>
                    </div>
		</div>
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

