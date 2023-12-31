<%@ page import="org.json.JSONArray" %>
<%@ page import="org.json.JSONObject" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.example.front.app.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="./img/audio-waves.png" type="image/x-icon">
    <title>VoiceMaster</title>

    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
</head>

<body id="page-top">
<%
    User user = (User) request.getAttribute("user");
%>
<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <ul style="background-color: #85a59e" class="navbar-nav sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/front_war_exploded">
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="fas">
                    <img style="width: 30px; height: 30px" src="./img/audio-waves-white.png" alt="Icon Description">
                </i>
            </div>
            <div class="sidebar-brand-text mx-3">VoiceMaster</div>
        </a>
        <!-- Divider -->
        <hr class="sidebar-divider my-0">

        <!-- Nav Item - Dashboard -->
        <li class="nav-item">
            <a class="nav-link" href="/front_war_exploded/course">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Selection Page</span></a>
        </li>

        <!-- Nav Item - Tables -->
        <li class="nav-item">
            <a class="nav-link" href="/front_war_exploded/login-log">
                <i class="fas fa-fw fa-table"></i>
                <span>Login Log</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link" href="/front_war_exploded/user">
                <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                <span>Profile</span>
            </a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider d-none d-md-block">

        <!-- Sidebar Toggler (Sidebar) -->
        <div class="text-center d-none d-md-inline">
            <button class="rounded-circle border-0" id="sidebarToggle"></button>
        </div>

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                <!-- Sidebar Toggle (Topbar) -->
                <form class="form-inline">
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>
                </form>


                <!-- Topbar Navbar -->
                <ul class="navbar-nav ml-auto">

                    <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                    <li class="nav-item dropdown no-arrow d-sm-none">
                        <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-search fa-fw"></i>
                        </a>
                        <!-- Dropdown - Messages -->
                        <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                             aria-labelledby="searchDropdown">
                            <form class="form-inline mr-auto w-100 navbar-search">
                                <div class="input-group">
                                    <input type="text" class="form-control bg-light border-0 small"
                                           placeholder="Search for..." aria-label="Search"
                                           aria-describedby="basic-addon2">
                                    <div class="input-group-append">
                                        <button class="btn btn-primary" type="button">
                                            <i class="fas fa-search fa-sm"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </li>

                    <!-- Nav Item - User Information -->
                    <li class="nav-item dropdown no-arrow">
                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="mr-2 d-none d-lg-inline text-gray-600 small"><%= user.getLastName() + " " + user.getFirstName()%></span>
                            <img class="img-profile rounded-circle"
                                 src="img/undraw_profile.svg">
                        </a>
                        <!-- Dropdown - User Information -->
                        <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="userDropdown">
                            <a class="dropdown-item" href="/front_war_exploded/user">
                                <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                Profile
                            </a>
                        </div>
                    </li>

                </ul>

            </nav>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">
                <%
                    Boolean userIdentity = user.getIdentity();
                    if (userIdentity) {
                %>
                <!-- Page Heading -->
                <div class="card shadow mb-4">

                    <div class="card-header py-3">
                        <h4 class="m-0 font-weight-bold text-primary">Course Management System</h4>
                    </div>
                    <div class="card-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group">
                                    <div class="p-2">
                                        <label class="text-lg text-primary">Course Title</label>
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user"
                                                   aria-describedby="emailHelp" placeholder="Course Title" id="title"
                                                   control-id="ControlID-1">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group">
                                    <div class="p-2">
                                        <label class="text-lg text-primary">Teacher</label>
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user"
                                                   aria-describedby="emailHelp" placeholder="Title" id="teacher"
                                                   control-id="ControlID-2">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group">
                                    <div class="p-2">
                                        <label class="text-lg text-primary">Course Content</label>
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user"
                                                   aria-describedby="emailHelp" placeholder="Course Content"
                                                   id="courseContent" control-id="ControlID-3">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group">
                                    <div class="p-2">
                                        <label class="text-lg text-primary">Difficulty</label>
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user"
                                                   aria-describedby="emailHelp" placeholder="Difficulty"
                                                   id="difficult" control-id="ControlID-3">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group">
                                    <div class="p-2">
                                        <label class="text-lg text-primary">Midterm Date</label>
                                        <div class="form-group">
                                            <input type="date" class="form-control form-control-user"
                                                   aria-describedby="emailHelp" id="midtermTime"
                                                   control-id="ControlID-3">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="form-group">
                                    <div class="p-2">
                                        <label class="text-lg text-primary">Final Date</label>
                                        <div class="form-group">
                                            <input type="date" class="form-control form-control-user"
                                                   aria-describedby="emailHelp" id="finalTime" control-id="ControlID-3">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group row justify-content-end">
                            <div class="col-lg-3 col-sm-3 mb-3 mb-sm-0">
                                <div class="p-3">
                                    <a href="#" class="btn btn-success btn-icon-split" id="CorU"
                                       onclick="createCourse()">
                                        <span class="icon text-white-50">
                                            <i class="fas fa-check"></i>
                                        </span>
                                        <span class="text" id="CorUText">Confirm</span>
                                    </a>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <%
                    }
                %>


                <!-- DataTales Example -->
                <div class="card shadow mb-4">
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable">
                                <thead>
                                <tr>
                                    <th>Course ID</th>
                                    <th>Course Title</th>
                                    <th>Teacher</th>
                                    <th>link</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                    JSONArray jsonArray = (JSONArray) request.getAttribute("courseList");
                                    Set<Integer> set = (Set<Integer>) request.getAttribute("selectedSet");
                                    for (int i = 0; i < jsonArray.length(); i++) {
                                %>
                                <tr>
                                    <th>
                                        <%= jsonArray.getJSONObject(i).getInt("id") %>
                                    </th>
                                    <th>
                                        <%= jsonArray.getJSONObject(i).getString("title") %>
                                    </th>
                                    <th>
                                        <%= jsonArray.getJSONObject(i).getString("teacher") %>
                                    </th>
                                    <th>
                                        <%
                                            if (userIdentity || set.contains(jsonArray.getJSONObject(i).getInt("id"))) {
                                        %>
                                        <a href="/front_war_exploded/class?class=<%= jsonArray.getJSONObject(i).getInt("id") %>">
                                            localhost/front_war_exploded/class?class_id=<%= jsonArray.getJSONObject(i).getInt("id") %>
                                        </a>
                                        <%
                                            }
                                        %>
                                    </th>
                                    <th>
                                        <%
                                            if (userIdentity) {
                                        %>
                                        <a href="#" class="btn btn-success btn-circle btn-sm"
                                           onclick="selectCourse(<%=jsonArray.getJSONObject(i).getInt("id")%>)"
                                        >
                                            <i class="fas fa-edit"></i>
                                        </a>
                                        <a href="#" class="btn btn-danger btn-circle btn-sm"
                                           onclick="deleteCourse(<%=jsonArray.getJSONObject(i).getInt("id")%>)"
                                        >
                                            <i class="fas fa-trash"></i>
                                        </a>
                                        <%
                                            }
                                        %>

                                        <%
                                            if (!userIdentity) {
                                                if (!set.contains(jsonArray.getJSONObject(i).getInt("id"))) {
                                        %>
                                        <a href="#" class="btn btn-success btn-circle btn-sm"
                                           onclick="createStudentCourse(<%=jsonArray.getJSONObject(i).getInt("id")%>)"
                                        >
                                            <i class="fas fa-check"></i>
                                        </a>
                                        <%
                                        } else {
                                        %>
                                        <a href="#" class="btn btn-danger btn-circle btn-sm"
                                           onclick="deleteStudentCourse(<%=jsonArray.getJSONObject(i).getInt("id")%>)"
                                        >
                                            <i class="fas fa-trash"></i>
                                        </a>

                                        <%
                                                }
                                            }
                                        %>
                                    </th>
                                </tr>
                                <%
                                    }
                                %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright &copy; Your Website 2020</span>
                </div>
            </div>
        </footer>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="index.html">Logout</a>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="vendor/datatables/jquery.dataTables.min.js"></script>
<script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

<!-- Page level custom scripts -->
<script src="js/demo/datatables-demo.js"></script>
<script>
    function createCourse() {
        let data = {
            "title": $('#title').val(),
            "teacher": $('#teacher').val(),
            "content": $('#courseContent').val(),
            "difficult": $('#difficult').val(),
            "midtermTime": $('#midtermTime').val(),
            "finalTime": $('#finalTime').val()
        }

        // 發送POST請求
        $.ajax({
            type: 'POST',
            url: '/front_war_exploded/course',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (response) {
                response = JSON.parse(response);
                if (response.status === 200) {
                    location.reload();
                } else {
                    alert(response.message);
                }
            },
            error: function (error) {
                console.error('Error:', error);
            }
        });
    }

    function deleteCourse(id) {
        let data = {"id": id}

        $.ajax({
            type: 'DELETE',
            url: '/front_war_exploded/course',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (response) {
                response = JSON.parse(response);
                if (response.status === 200) {
                    location.reload();
                } else {
                    alert(response.message);
                }
            },
            error: function (error) {
                console.error('Error:', error);
            }
        });
    }

    function updateCourse(id) {
        let data = {
            "id": id,
            "title": $('#title').val(),
            "teacher": $('#teacher').val(),
            "content": $('#courseContent').val(),
            "difficult": $('#difficult').val(),
            "midtermTime": $('#midtermTime').val(),
            "finalTime": $('#finalTime').val()
        }

        // 發送POST請求
        $.ajax({
            type: 'PUT',
            url: '/front_war_exploded/course',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (response) {
                response = JSON.parse(response);
                if (response.status === 200) {
                    location.reload();
                } else {
                    alert(response.message);
                }
            },
            error: function (error) {
                console.error('Error:', error);
            }
        });

    }

    function selectCourse(id) {

        $.ajax({
            type: "GET",
            url: "/front_war_exploded/course",
            crossDomain: true,
            headers: {"id": id},
            cache: false,
            dataType: 'json',
            timeout: 5000,
            success: function (response) {
                if (response.status === 200) {
                    $('#title').val(response.response.title);
                    $('#teacher').val(response.response.teacher);
                    $('#courseContent').val(response.response.content);
                    $('#difficult').val(response.response.difficult);
                    $('#midtermTime').val(response.response.midtermTime);
                    $('#finalTime').val(response.response.finalTime);
                    $("#CorUText").text("Update");
                    $("#CorU").attr("onclick", "updateCourse(" + response.response.id + ")");
                }
            },
            error: function () {
                alert("無法連線到伺服器！");
            }
        });
    }

    function createStudentCourse(id) {
        let data = {
            "id": id
        }

        // 發送POST請求
        $.ajax({
            type: 'POST',
            url: '/front_war_exploded/student-course',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (response) {
                response = JSON.parse(response);
                if (response.status === 200) {
                    location.reload();
                } else {
                    alert(response.message);
                }
            },
            error: function (error) {
                console.error('Error:', error);
            }
        });
    }

    function deleteStudentCourse(id) {
        let data = {
            "id": id
        }

        // 發送POST請求
        $.ajax({
            type: 'DELETE',
            url: '/front_war_exploded/student-course',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (response) {
                response = JSON.parse(response);
                if (response.status === 200) {
                    location.reload();
                } else {
                    alert(response.message);
                }
            },
            error: function (error) {
                console.error('Error:', error);
            }
        });
    }

</script>
</body>

</html>