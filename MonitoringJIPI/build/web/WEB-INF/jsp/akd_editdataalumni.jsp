<%-- 
    Document   : charts
    Created on : Aug 27, 2017, 4:05:56 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<link rel="stylesheet" href="js/date/jquery-ui.css" type="text/css"/>
<script src="js/date/jquery-1.10.2.js" type="text/javascript"></script>
<script src="js/date/jquery-ui.js" type="text/javascript"></script>
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
            
            <center>
		<!--/.row-->
                <div class="row">
                    <!-- /////////////////////////////////////////////////////////////-->
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading"> Form Edit Data Alumni</div>
                            <div class="panel-body">
                                <form:form class="form-horizontal" id="formEditAlumni" action="editDataAlumni.htm" method="post" modelAttribute="dto">
                                    <form:hidden path="kdalumni" value="${dto.kdalumni}" />
                                    <fieldset>
                                        
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >NIM</label>
                                            <div class="col-md-9">
                                                <form:input path="nim" value="${dto.nim}" id="txnim" class="form-control"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Kode Kelulusan</label>
                                            <div class="col-md-9">
                                                <form:input path="kdkelulusan" value="${dto.kdkelulusan}" class="form-control"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Mulai Bekerja</label>
                                            <div class="col-md-9">
                                                <form:input path="tglmulaikerja" id="tg_mulaikerja" value="${dto.tglmulaikerja}" class="form-control validate validate[required]"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Perusahaan</label>
                                            <div class="col-md-9">
                                                <form:input path="perusahaan" value="${dto.perusahaan}" class="form-control validate validate[required]"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Email Perusahaan</label>
                                            <div class="col-md-9">
                                                <form:input path="emailperusahaan" value="${dto.emailperusahaan}" class="form-control validate validate[required]"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Alamat Perusahaan</label>
                                            <div class="col-md-9">
                                                <form:input path="alamatperusahaan" value="${dto.alamatperusahaan}" class="form-control validate validate[required]"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Daerah Kerja</label>
                                            <div class="col-md-9">
                                                    <form:input path="daerahkerja" value="${dto.daerahkerja}" class="form-control validate validate[required]"/>
                                            </div>
                                        </div>
                                        <div class="form-group" value="${dto.sektor}">
                                            <label class="col-md-3 control-label" >Sektor</label>
                                            <div class="col-md-2">
                                                    <form:radiobutton path="sektor" value="bumn" class="form-control"/>BUMN
                                            </div>
                                            <div class="col-md-2">
                                                    <form:radiobutton path="sektor" value="swasta" class="form-control"/>Swasta
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Profesi</label>
                                            <div class="col-md-9">
                                                <form:input path="profesi"  value="${dto.profesi}" class="form-control validate validate[required]"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Testimoni</label>
                                            <div class="col-md-9">
                                                <form:input path="testimoni" value="${dto.testimoni}" class="form-control validate validate[required]"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Photo</label>
                                            <div class="col-md-9">
                                                <form:input path="foto" value="${dto.foto}" class="form-control validate validate[required]"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >EVALUASI LULUSAN</label>
                                        </div>
                                        <div class="form-group" value="${dto.integritas}">
                                            <label class="col-md-3 control-label" >Integritas (etika dan moral)</label>
                                            <div class="col-md-1">
                                                    <form:radiobutton path="integritas" value="4" class="form-control"/>Sangat Baik
                                            </div>
                                            <div class="col-md-1">
                                                    <form:radiobutton path="integritas" value="3" class="form-control"/>Baik
                                            </div>
                                            <div class="col-md-1">
                                                    <form:radiobutton path="integritas" value="2" class="form-control"/>Cukup
                                            </div>
                                            <div class="col-md-1">
                                                    <form:radiobutton path="integritas" value="1" class="form-control"/>Kurang
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Keahlian berdasarkan bidang ilmu (profesionalisme)</label>
                                            <div class="col-md-1">
                                                    <form:radiobutton path="keahlian" value="4" class="form-control"/>Sangat Baik
                                            </div>
                                            <div class="col-md-1">
                                                    <form:radiobutton path="keahlian" value="3" class="form-control"/>Baik
                                            </div>
                                            <div class="col-md-1">
                                                    <form:radiobutton path="keahlian" value="2" class="form-control"/>Cukup
                                            </div>
                                            <div class="col-md-1">
                                                    <form:radiobutton path="keahlian" value="1" class="form-control"/>Kurang
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Bahasa Inggris</label>
                                            <div class="col-md-1">
                                                    <form:radiobutton path="inggris" value="4" class="form-control"/>Sangat Baik
                                            </div>
                                            <div class="col-md-1">
                                                    <form:radiobutton path="inggris" value="3" class="form-control"/>Baik
                                            </div>
                                            <div class="col-md-1">
                                                    <form:radiobutton path="inggris" value="2" class="form-control"/>Cukup
                                            </div>
                                            <div class="col-md-1">
                                                    <form:radiobutton path="inggris" value="1" class="form-control"/>Kurang
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Penggunaan Teknologi Informasi</label>
                                            <div class="col-md-1">
                                                    <form:radiobutton path="teknologi" value="4" class="form-control"/>Sangat Baik
                                            </div>
                                            <div class="col-md-1">
                                                    <form:radiobutton path="teknologi" value="3" class="form-control"/>Baik
                                            </div>
                                            <div class="col-md-1">
                                                    <form:radiobutton path="teknologi" value="2" class="form-control"/>Cukup
                                            </div>
                                            <div class="col-md-1">
                                                    <form:radiobutton path="teknologi" value="1" class="form-control"/>Kurang
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Komunikasi</label>
                                            <div class="col-md-1">
                                                    <form:radiobutton path="komunikasi" value="4" class="form-control"/>Sangat Baik
                                            </div>
                                            <div class="col-md-1">
                                                    <form:radiobutton path="komunikasi" value="3" class="form-control"/>Baik
                                            </div>
                                            <div class="col-md-1">
                                                    <form:radiobutton path="komunikasi" value="2" class="form-control"/>Cukup
                                            </div>
                                            <div class="col-md-1">
                                                    <form:radiobutton path="komunikasi" value="1" class="form-control"/>Kurang
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Kerjasama Tim</label>
                                            <div class="col-md-1">
                                                    <form:radiobutton path="kerjasama" value="4" class="form-control"/>Sangat Baik
                                            </div>
                                            <div class="col-md-1">
                                                    <form:radiobutton path="kerjasama" value="3" class="form-control"/>Baik
                                            </div>
                                            <div class="col-md-1">
                                                    <form:radiobutton path="kerjasama" value="2" class="form-control"/>Cukup
                                            </div>
                                            <div class="col-md-1">
                                                    <form:radiobutton path="kerjasama" value="1" class="form-control"/>Kurang
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Pengembangan Diri</label>
                                            <div class="col-md-1">
                                                    <form:radiobutton path="pengembangan" value="4" class="form-control"/>Sangat Baik
                                            </div>
                                            <div class="col-md-1">
                                                    <form:radiobutton path="pengembangan" value="3" class="form-control"/>Baik
                                            </div>
                                            <div class="col-md-1">
                                                    <form:radiobutton path="pengembangan" value="2" class="form-control"/>Cukup
                                            </div>
                                            <div class="col-md-1">
                                                    <form:radiobutton path="pengembangan" value="1" class="form-control"/>Kurang
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-md-12 widget-right">
                                                <input type="submit" class="btn btn-primary btn-md pull-right"  id="sbm" value="Edit" />
                                            </div>
                                        </div>
                                    </fieldset><!--
                                </form:form>
                            </div>
                        </div>
                    </div><!--/.col-->
                </div>
<!--                        ////////////////////////////////////////-->






            </center>



        </div>	<!--/.main-->


        	
    </body>

</html>
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

            var jQuery_1_11_1=$.noConflict(true);
            jQuery_1_11_1(document).ready(function(){
            jQuery_1_11_1("#sbm").click(function (evt){ //id tombol submit
            evt.preventDefault();
            var validate=jQuery_1_11_1('#formTambahProposal').validationEngine('validate'); // id form
            if(validate){
                jQuery_1_11_1("#formTambahProposal").submit();
            }else{
                return false;
            }
        });
    
        });
    
    
    
    $(function() {
    //$("#tg_pj").datepicker({dateFormat: 'dd-mm-yy'});
    $( "#tg_ls" ).datepicker();
    
    });
    $(function() {
    //$("#tg_pj").datepicker({dateFormat: 'dd-mm-yy'});
    $( "#tg_awal" ).datepicker();
    
    });
    $(function() {
    //$("#tg_pj").datepicker({dateFormat: 'dd-mm-yy'});
    $( "#tg_last" ).datepicker();
    
    });
    $(function() {
    //$("#tg_pj").datepicker({dateFormat: 'dd-mm-yy'});
    $( "#tg_mulaikerja" ).datepicker();
    
    });
    
//    $("#txnim").focusout(function () {// id asal
//                var nim = $('#txnim').val();
//                $.ajax({
//                    type: "POST",
//                    url: "otomatisDataSiswa1.htm",
//                    data: "nim"+nim,
//                    success: function (response) {
//                        $("#txnama").val(response);// id yang dituju
//                    },
//                    error: function (e) {
//                        alert('Error: ' + e);
//                    }
//                });
//            });
           
        </script>

