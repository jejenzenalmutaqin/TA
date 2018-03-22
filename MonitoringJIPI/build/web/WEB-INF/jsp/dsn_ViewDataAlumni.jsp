
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<!--script menyisipkan jquery-->
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="js/validation/css/validationEngine.jquery.css">
<script type="text/javascript" src="js/validation/jquery.validationEngine-en.js"></script>
<script type="text/javascript" src="js/validation/jquery.validationEngine.js"></script>
<!--script menyisipkan jquery-->
<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Data Alumni</title>

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
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> Ilfa Sri Desy <span class="caret"></span></a>
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
			<li><a href="akd_index.htm"><svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-dashboard-dial"></use></svg> Home</a></li>
			<li><a href="akd_datauser.htm"><svg class="glyph stroked calendar"><use xlink:href="#stroked-calendar"></use></svg> Data User</a></li>
			<li class="active"><a href="akd_pengajuanproposal.htm"><svg class="glyph stroked line-graph"><use xlink:href="#stroked-line-graph"></use></svg> Pengajuan Proposal</a></li>
			<li><a href="akd_pengajuansidang.htm"><svg class="glyph stroked table"><use xlink:href="#stroked-table"></use></svg> Pengajuan Sidang</a></li>
			<li><a href="akd_datakelulusan.htm"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg> Data Kelulusan</a></li>
			<li><a href="akd_dataalumni.htm"><svg class="glyph stroked app-window"><use xlink:href="#stroked-app-window"></use></svg> Data Alumni</a></li>
			<li class="parent ">
				<a href="#">
					<span data-toggle="collapse" href="#sub-item-1"><svg class="glyph stroked chevron-down"><use xlink:href="#stroked-chevron-down"></use></svg></span> Laporan 
				</a>
				<ul class="children collapse" id="sub-item-1">
					<li>
						<a class="" href="akd_laporanpengajuanproposal.htm">
							<svg class="glyph stroked chevron-right"><use xlink:href="#stroked-chevron-right"></use></svg> Pengajuan Proposal
						</a>
					</li>
					<li>
						<a class="" href="akd_laporanpengajuansidang.htm">
							<svg class="glyph stroked chevron-right"><use xlink:href="#stroked-chevron-right"></use></svg> Pengajuan Sidang
						</a>
					</li>
					<li>
						<a class="" href="akd_laporandatakelulusan.htm">
							<svg class="glyph stroked chevron-right"><use xlink:href="#stroked-chevron-right"></use></svg> Data Kelulusan
						</a>
					</li>
                                        <li>
						<a class="" href="akd_laporandatakelulusan.htm">
							<svg class="glyph stroked chevron-right"><use xlink:href="#stroked-chevron-right"></use></svg> Data Alumni
						</a>
					</li>
				</ul>
			</li>
			<li role="presentation" class="divider"></li>
		</ul>

	</div><!--/.sidebar-->
<!--        begin-content-->
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
            
            <br><br>
            <center>
                <div class="row">
                    <div class="col-md-12">
                        
                        <div class="panel panel-blue">
                            <div class="panel-heading dark-overlay">Data Alumni</div>
                            <div class="panel-body">
                                
                                <table border="4">
                                    <tr>
                                        <th class="col-md-2 control-label">Nim</th>
                                        <th class="col-md-2 control-label">Nama</th>
                                        <th class="col-md-2 control-label">Fakultas</th>
                                        <th class="col-md-2 control-label">IPK</th>
                                        <th class="col-md-2 control-label">Tanggal Lulus</th>
                                        <th class="col-md-2 control-label">Angkatan</th>
                                        <th class="col-md-2 control-label">Profesi</th>
                                        <th class="col-md-2 control-label">Tempat Kerja</th>
                                        <th class="col-md-2 control-label">Alamat Tempat Kerja</th>
                                        <th class="col-md-2 control-label">Sektor</th>
                                        
                                    </tr>
                                    
                                    <%--<c:set var="index" value="1"/>--%>
                                    <c:forEach var="listProp" items="${listDto}">
                                        <tr>  
                                            <td align="center" class="col-md-2 control-label">${listProp.nim}</td>
                                            <td align="center" class="col-md-2 control-label">${listProp.namamahasiswa}</td>
                                            <td align="center" class="col-md-2 control-label">${listProp.namafakultas}</td>
                                            <td align="center" class="col-md-2 control-label">${listProp.ipk}</td>
                                            <td align="center" class="col-md-2 control-label">${listProp.tgllulus}</td>
                                            <td align="center" class="col-md-2 control-label">${listProp.angkatan}</td>
                                            <td align="center" class="col-md-2 control-label">${listProp.profesi}</td>
                                            <td align="center" class="col-md-2 control-label">${listProp.perusahaan}</td>
                                            <td align="center" class="col-md-2 control-label">${listProp.alamatperusahaan}</td>
                                            <td align="center" class="col-md-2 control-label">${listProp.sektor}</td>
                                            
                                          </tr>            
                                    </c:forEach>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </center>
        </div>	<!--/.main-->


        <script src="js/jquery-1.11.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/chart.min.js"></script>
        <script src="js/chart-data.js"></script>
        <script src="js/easypiechart.js"></script>
        <script src="js/easypiechart-data.js"></script>
        <script src="js/bootstrap-datepicker.js"></script>
        <script type="text/javascript">
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

            $("#bb").focusout(function () {// id asal
                var bb = $('#bb').val();
                $.ajax({
                    type: "POST",
                    url: "otomatisDataSiswa1.htm",
                    data: "banyakBulan"+bb,
                    success: function (response) {
                        $("#ket").val(response);// id yang dituju
                    },
                    error: function (e) {
                        alert('Error: ' + e);
                    }
                });
            });
           
        </script>	
    </body>

</html>

