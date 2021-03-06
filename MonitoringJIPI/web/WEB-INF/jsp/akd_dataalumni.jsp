<%-- 
    Document   : charts
    Created on : Aug 27, 2017, 4:05:56 PM
    Author     : hp
--%>

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
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		
		<ul class="nav menu">
			<li><a href="akd_index.htm"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg> Home</a></li>
			<li><a href="akd_datauser.htm"><svg class="glyph stroked female user"><use xlink:href="#stroked-female-user"></use></svg> Data User</a></li>
			<li><a href="akd_pengajuanproposal.htm"><svg class="glyph stroked clipboard with paper"><use xlink:href="#stroked-clipboard-with-paper"></use></svg> Pengajuan Proposal</a></li>
			<li><a href="akd_pengajuansidang.htm"><svg class="glyph stroked table"><use xlink:href="#stroked-table"></use></svg> Pengajuan Sidang</a></li>
			<li><a href="akd_datakelulusan.htm"><svg class="glyph stroked calendar"><use xlink:href="#stroked-calendar"></use></svg> Data Kelulusan</a></li>
			<li class="active"><a href="akd_dataalumni.htm"><svg class="glyph stroked app-window"><use xlink:href="#stroked-app-window"></use></svg> Data Alumni</a></li>
			<li><a href="akd_kirimemail.htm"><svg class="glyph stroked email"><use xlink:href="#stroked-email"></use></svg> Kirim Email</a></li>
			<li><a href="akd_buatnotifikasi.htm"><svg class="glyph stroked empty message"><use xlink:href="#stroked-empty-message"></use></svg> Notifikasi</a></li>
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
						<a class="" href="akd_laporandataalumni.htm">
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
            <div class="form-group">
                <c:url var="tambahData" value="/tambahAlumni.htm"></c:url>
                <div class="col-md-5"><a href="${tambahData}"><button class="btn btn-primary">TAMBAH</button></a></div>
                <form method="post" action="cariAlumni.htm">
                    <div class="col-md-2">
                    <select class="form-control" id="drop" name="cariBerdasarkan">
                        <option value="1">Kode Alumni</option>
                        <option value="2">NIM</option>
                        <option value="3">Nama</option>
                        <option value="4">Kode Kelulusan</option>
                        <option value="5">Daerah Kerja</option>
                        <option value="6">Sektor</option>
                        <option value="7">Profesi</option>
                        <option value="8">Semua</option>
                    </select>
                </div>
                    <div class="col-md-3">
                    <input type="text" placeholder="Masukan Kata Kunci" name="cariKey" class="form-control"><br>
                    
                    </div>
                    <div class=""><button class="btn btn-primary" type="submit">CARI</button></div>
                </form>
            </div>
            <br><br>
            <center>
		<!--/.row-->
                <div class="row">
                    
                    <!-- /////////////////////////////////////////////////////////////-->
                    <div class="col-md-12">
                        
                        <div class="panel panel-blue">
                            <div class="panel-heading dark-overlay">Tabel Data Alumni</div>
                            <div class="panel-body">
                                
                                <table style="color: white"  border="4">
                                    <tr>
                                        <th class="col-md-2 control-label" style="text-align: center">Kode Alumni</th>
                                        <th class="col-md-2 control-label" style="text-align: center">Nama</th>
                                        <th class="col-md-2 control-label" style="text-align: center">Kode Kelulusan</th>
                                        <th class="col-md-2 control-label" style="text-align: center">Perusahaan</th>
                                        <th class="col-md-2 control-label" style="text-align: center">Alamat Perusahaan</th>
                                        <th class="col-md-2 control-label" style="text-align: center">Daerah Kerja</th>
                                        <th class="col-md-2 control-label" style="text-align: center">Sektor</th>
                                        <th class="col-md-2 control-label" style="text-align: center">Profesi</th>
                                        <th style="text-align: center" colspan="3" class="col-md-3 control-label">Action</th>
                                    </tr>
                                    
                                    <%--<c:set var="index" value="1"/>--%>
                                    <c:forEach var="listAlumni" items="${listDto}">
                                        <tr>  
                                            <td align="center" class="col-md-2 control-label">${listAlumni.kdalumni}</td>
                                            <td align="center" class="col-md-2 control-label">${listAlumni.nim}</td>
                                            <td align="center" class="col-md-2 control-label">${listAlumni.kdkelulusan}</td>
                                            <td align="center" class="col-md-2 control-label">${listAlumni.perusahaan}</td>
                                            <td align="center" class="col-md-2 control-label">${listAlumni.alamatperusahaan}</td>
                                            <td align="center" class="col-md-2 control-label">${listAlumni.daerahkerja}</td>
                                            <td align="center" class="col-md-2 control-label">${listAlumni.sektor}</td>
                                            <td align="center" class="col-md-2 control-label">${listAlumni.profesi}</td>

                                            <c:url var="hapusList" value="/hapusListAlumni.htm">
                                                <c:param name="kdalumni" value="${listAlumni.kdalumni}"/>
                                            </c:url>
                                            <c:url var="editList" value="/editAlumni.htm">
                                                <c:param name="kdalumni" value="${listAlumni.kdalumni}"/>
                                            </c:url>
                                            <c:url var="detailList" value="/detailAlumni.htm">
                                                <c:param name="kdalumni" value="${listAlumni.kdalumni}"/>
                                            </c:url>
                                            <td align="center"><a href="${hapusList}"><label style="color: red" class="col-md-3 control-label" >Hapus</label></a></td>
                                            <td align="center"><a href="${editList}"><label style="color: greenyellow" class="col-md-3 control-label" >Edit</label></a></td>
                                            <td align="center"><a href="${detailList}"><label style="color: yellow" class="col-md-3 control-label" >Detail</label></a></td>
                                        </tr>            
                                      <%--  <c:set var="index" value="${index+1}"/>--%>
                                    </c:forEach>
                                </table>
                            </div>
                        </div>


                    </div><!--/.col-->
                </div>
<!--                        ////////////////////////////////////////-->






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

