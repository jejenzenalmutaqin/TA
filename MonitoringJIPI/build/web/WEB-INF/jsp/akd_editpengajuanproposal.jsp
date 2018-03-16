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
        <title>Data Pengajuan Proposal</title>

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
                    <li class="active">Pengajuan Proposal</li>
                </ol>
            </div><!--/.row-->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Pengajuan Proposal</h1>

                </div>
            </div><!--/.row-->
            
            <center>
		<!--/.row-->
                <div class="row">
                    <!-- /////////////////////////////////////////////////////////////-->
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-heading"> Form Edit Data Pengajuan Proposal</div>
                            <div class="panel-body">
                                <form:form class="form-horizontal" id="formEditProposal" action="editDataPengajuanProposal.htm" method="post" modelAttribute="dto">
                                    <form:hidden path="kdproposal" value="${dto.kdproposal}" />
                                    <fieldset>
                                        
<!--                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Kode Jenis Pengajuan</label>
                                            <div class="col-md-9">
                                                <%--<form:input path="kdjenisproposal" placeholder="Kode Jenis Pengajuan" class="form-control"/>--%>
                                            </div>
                                        </div>-->
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Kode Jenis Pengajuan</label>
                                            <div class="col-md-9">

                                                <form:select path="kdjenisproposal" value="${dto.kdjenisproposal}" class="form-control validate validate[required]">
                                                    <form:option value="${dto.kdjenisproposal}" selected="true" disabled="true">Pilih Jenis Pengajuan</form:option>
                                                    <c:forEach var="jns" items="${listJns}">
                                                        <form:option value="${jns.kdjenispengajuan}">${jns.namajenispengajuan}</form:option>
                                                    </c:forEach>
                                                </form:select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >NIM</label>
                                            <div class="col-md-9">
                                                <form:input path="nim" value="${dto.nim}" class="form-control"/>
                                            </div>
                                        </div>
<!--                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >NAMA</label>
                                            <div class="col-md-9">
<%--<form:input path="" placeholder="NAMA" id="txnama" class="form-control"/>--%>
                                            </div>
                                        </div>-->
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Judul Proposal</label>
                                            <div class="col-md-9">
                                                <%--<form:input path="judulproposal" placeholder="Judul Proposal" class="form-control validate validate[required]"/>--%>
                                                <form:textarea path="judulproposal" value="${dto.judulproposal}" class="form-control validate validate[required]"/>
                                            
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >SKS Tempuh</label>
                                            <div class="col-md-9">
                                                <form:input path="skssudahtempuh" value="${dto.skssudahtempuh}" class="form-control validate validate[required]"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >SKS Proposal</label>
                                            <div class="col-md-9">
                                                <form:input path="sksproposal" value="${dto.sksproposal}" class="form-control validate validate[required]"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Tanggal Pengajuan Proposal</label>
                                            <div class="col-md-9">
                                                <form:input path="tglpengajuanproposal" id="tgl_pgj" value="${dto.tglpengajuanproposal}" class="form-control validate validate[required]"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >IPK</label>
                                            <div class="col-md-9">
                                                <form:input path="ipk" value="${dto.ipk}" class="form-control validate validate[required]"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >E-mail</label>
                                            <div class="col-md-9">
                                                <form:input path="email" value="${dto.email}" class="form-control validate validate[required]"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Dosen Pembimbing</label>
                                            <div class="col-md-9">
                                                <form:input path="dosenpembimbing" value="${dto.dosenpembimbing}" class="form-control validate validate[required]"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-3 control-label" >Status Proposal</label>
                                            <div class="col-md-9">
                                                <form:input path="statusproposal" pvalue="${dto.statusproposal}" class="form-control validate validate[required]"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-md-12 widget-right">
                                                <input type="submit" class="btn btn-primary btn-md pull-right"  id="sbm" value="Edit" />
                                            </div>
                                        </div>

                                        
                                    </fieldset>
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
    $( "#tgl_pgj" ).datepicker();
    
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

