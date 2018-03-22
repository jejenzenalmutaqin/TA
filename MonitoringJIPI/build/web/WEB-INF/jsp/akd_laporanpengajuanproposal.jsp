<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="js/validation/css/validationEngine.jquery.css"/>
<script type="text/javascript" src="js/validation/jquery.validationEngine-en.js"></script>
<script type="text/javascript" src="js/validation/jquery.validationEngine.js"></script>

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
    <div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">

        <ul class="nav menu">
            <li class="active"><a href="akd_index.htm"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg> Home</a></li>
            <li><a href="akd_datauser.htm"><svg class="glyph stroked female user"><use xlink:href="#stroked-female-user"></use></svg> Data User</a></li>
            <li><a href="akd_pengajuanproposal.htm"><svg class="glyph stroked clipboard with paper"><use xlink:href="#stroked-clipboard-with-paper"></use></svg> Pengajuan Proposal</a></li>
            <li><a href="akd_pengajuansidang.htm"><svg class="glyph stroked table"><use xlink:href="#stroked-table"></use></svg> Pengajuan Sidang</a></li>
            <li><a href="akd_datakelulusan.htm"><svg class="glyph stroked calendar"><use xlink:href="#stroked-calendar"></use></svg> Data Kelulusan</a></li>
            <li><a href="akd_dataalumni.htm"><svg class="glyph stroked app-window"><use xlink:href="#stroked-app-window"></use></svg> Data Alumni</a></li>
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

    <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
        <div class="row">
            <ol class="breadcrumb">
                <li><a href="akd_index.htm"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
                <li class="active">Laporan Pengajuan Proposal</li>
            </ol>
        </div><!--/.row-->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Filter Laporan Pengajuan Proposal</h1>

            </div>
        </div><!--/.row-->
        <center>
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading"> Form Filter Laporan Pengajuan Proposal</div>
                        <div class="panel-body">
                            <form class="form-horizontal" id="filterProposal" action="laporanproposal.htm" method="get">
                                <fieldset>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" >Pilih Fakultas</label>
                                        <div class="col-md-9">
                                            <select name="fakultas_filter" id="fakultas_id" class="form-control validate validate[required]">
                                                <option value="seluruh">- Semua Fakultas -</option>
                                                <c:forEach var="fak"  items="${listFakultas}">
                                                    <option  value="${fak.kdfakultas}">${fak.namafakultas}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" >Pilih Jurusan</label>
                                        <div class="col-md-9">
                                            <select name="jurusan_filter" id="jurusan_id" class="form-control validate validate[required]">
                                                <option value="seluruh">- Semua Jurusan -</option>
                                                <c:forEach var="jur" items="${listJurusan}">
                                                    <option  value="${jur.kdjurusan}">${jur.namajurusan}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                        
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" >Jenis Proposal</label>
                                        <div class="col-md-1">
                                            <input type="radio" name="jenis_filter" value="1" class="form-control"/>TA
                                        </div>
                                        <div class="col-md-1">
                                            <input type="radio" name="jenis_filter" value="2" class="form-control"/>UP
                                        </div>
                                        <div class="col-md-1">
                                            <input type="radio" name="jenis_filter" value="3" class="form-control"/>Skripsi
                                        </div>
                                        <div class="col-md-1">
                                            <input type="radio" name="jenis_filter" value="seluruh" class="form-control" checked="true"/>Seluruh
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" >Pilih Angkatan</label>
                                        <div class="col-md-9">
                                            <select name="angkatan_filter" class="form-control validate validate[required]">
                                                <option value="seluruh">-- Semua Angkatan --</option>
                                                <option value="2002" >2002</option>
                                                <option value="2003" >2003</option>
                                                <option value="2004" >2004</option>
                                                <option value="2005" >2005</option>
                                                <option value="2006" >2006</option>
                                                <option value="2007" >2007</option>
                                                <option value="2008" >2008</option>
                                                <option value="2009" >2009</option>
                                                <option value="2010" >2010</option>
                                                <option value="2011" >2011</option>
                                                <option value="2012" >2012</option>
                                                <option value="2013" >2013</option>
                                                <option value="2014" >2014</option>
                                                <option value="2015" >2015</option>
                                                <option value="2016" >2016</option>
                                                <option value="2017" >2017</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" >Pilih Cetak</label>
                                        <div class="col-md-1">
                                            <input type="radio" name="cetak_filter" value="1" class="form-control" checked="true"/>Excel
                                        </div>
                                        <div class="col-md-1">
                                            <input type="radio" name="cetak_filter" value="2" class="form-control"/>PDF
                                        </div>
                                        
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-3 control-label" ></label>
                                        <div class="col-md-9 widget-right">
                                            <input type="submit" class="btn btn-primary form-control"  id="sbm" value="Download" />
                                        </div>
                                    </div>


                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div><!--/.col-->
            </div><!--/.row-->
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
    <script type="text/javascript">
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
//        $(document).ready(function(){
//            $("#fakultas_id").change(function () {
//                var fakultas_id = $('#fakultas_id').val();
//                $.ajax({
//                    type: 'POST',
//                    url: "changeJurusanByFakultas.htm",
//                    data: "param=" + fakultas_id,
//                    success: function (response) {
//                        //$("#jurusan_id").val(response);
////                        var obj = JSON.parse(response);
//                        console.log('==========================');
//                        console.log(response);
//                    },
//                    error: function (e) {
//                        console.log('masuk error==========================');
//                        alert('Error :' + e);
//                    }
//                });
//            });
//        });
    </script>	
</body>

</html>

