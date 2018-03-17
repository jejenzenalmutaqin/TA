<%-- 
    Document   : mhs_berandaalumni
    Created on : Mar 16, 2018, 10:46:45 PM
    Author     : hp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
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
                <li><a href="${panggilNotif}"><svg class="glyph stroked line-graph"><use xlink:href="#stroked-line-graph"></use></svg> Notifikasi</a></li>
                <li class="active"><a href="${panggilBerandaAlumni}"><svg class="glyph stroked table"><use xlink:href="#stroked-table"></use></svg> Beranda Alumni</a></li>
                <li role="presentation" class="divider"></li>

            </ul>

        </div><!--/.sidebar-->
        <!--        begin-content-->
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="akd_index.htm"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
                    <li class="active">Beranda Alumni</li>
                </ol>
            </div><!--/.row-->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Beranda Alumni</h1>

                </div>
            </div><!--/.row-->
            <div class="form-group">
                <%--<c:url var="tambahData" value="/tambahAlumni.htm"></c:url>--%>
                <!--<div class="col-md-5"><a href="${tambahData}"><button class="btn btn-primary">TAMBAH</button></a></div>-->
                <script>
                        function aktif()
                        {
                            document.alumni.fakultas_filter.disabled = true;
                        }
                        function mati()
                        {
                            document.alumni.fakultas_filter.disabled = false;
                        }
                    </script>
                <form method="post" action="caridataalumni.htm" name="alumni">
                    <c:set var="fakDisabled" value="false"/>
                    <%--<c:--%>
                    
                    <div class="form-group">
                        <label class="col-md-3 control-label" >Filter Berdasarakan</label>
                        <div class="col-md-9">
                            <div class="radio">
                                <label>
                                    <input type="radio" name="optionsRadios" onclick="aktif()" id="optionsRadios1" value="option1" checked>Fakultas dan Jurusan
                                </label>
                            </div>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="optionsRadios" onclick="mati()" id="optionsRadios2" value="option2">lainnya
                                </label>
                            </div>
                        </div>
                    </div>

                    

<!--                    <form name="contoh">
                        <button name="tombol" type="button" value="4" onclick="test()">Coba di klik</button>	
                        <input type="text" name="opsional" class="text" disabled="" />	    	
                    </form>-->

                    <div class="form-group">
                        <label class="col-md-3 control-label" >Pilih Fakultas</label>
                        <div class="col-md-9">
                            <select name="fakultas_filter" disabled="" id="fakultas_id" class="form-control validate validate[required]">
                                <option value="" selected="true">-- Semua Fakultas --</option>
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
                                <option value="" selected="true">-- Semua Jurusan --</option>
                                <c:forEach var="fak" items="${listJurusan}">
                                    <option value="${fak.kdjurusan}">${fak.namajurusan}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label" >Pilih Angkatan</label>
                        <div class="col-md-9">
                            <select name="angkatan_filter" class="form-control validate validate[required]">
                                <option value="" selected="true" disabled="true">-- Semua Angkatan --</option>
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
                        <label class="col-md-3 control-label" >Search By </label>
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

                                <table border="4">
                                    <tr>
                                        <th class="col-md-2 control-label">Kode Alumni</th>
                                        <th class="col-md-2 control-label">Nama</th>
                                        <th class="col-md-2 control-label">Kode Kelulusan</th>
                                        <th class="col-md-2 control-label">Perusahaan</th>
                                        <th class="col-md-2 control-label">Alamat Perusahaan</th>
                                        <th class="col-md-2 control-label">Daerah Kerja</th>
                                        <th class="col-md-2 control-label">Sektor</th>
                                        <th class="col-md-2 control-label">Profesi</th>
                                        <th style="text-align: center" colspan="2" class="col-md-3 control-label">Action</th>
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
                                            <c:url var="editList" value="/editMhsAlumni.htm">
                                                <c:param name="kdalumni" value="${listAlumni.kdalumni}"/>
                                            </c:url>
                                            <td align="center"><a href="#"><label style="color: greenyellow" class="col-md-3 control-label" >View</label></a></td>
                                            <c:set var="nimAlumni" value="${listAlumni.nim}"/>
                                            <c:set var="nimAlumna" value="0204151015"/>
                                            <%--<c:if test="${nimAlumni==nimAlumna}">--%>
                                            <td align="center"><a href="${editList}"><label style="color: greenyellow" class="col-md-3 control-label" >Edit</label></a></td>
                                            <%--</c:if>--%>
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
                                    data: "banyakBulan" + bb,
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
