<#import "parts/layout.ftl" as layout>
<@layout.page>
    <div class="page-body" style="background: #FAF0E6">
        <div class="container-fluid">
            <div class="page-header">
                <div class="row">
                    <div class="col-lg-6 main-header">
                        <h2 style="color: orange">Basic DataTables</h2>
                        <h6 class="mb-0" style="color: black">admin panel</h6>
                    </div>
                    <div class="col-lg-6 breadcrumb-right">
                        <ol class="breadcrumb">
                            <li><a href="/"><p style="color: orange">Home /</p></a></li>
                            <li style="color: orange"><p>Friends</p></li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>
        <!-- Container-fluid starts-->
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-12">
                    <div class="card">
                        <div class="card-header">
                            <h5>Friends list</h5>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="display" id="basic-2">
                                    <thead>
                                    <tr>
                                        <th>Name</th>
                                        <th>Account created date</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <#list friends as friend>
                                        <tr>
                                            <td><a style="color: orangered;"
                                                   href="/user/${friend.getUsername()}">${friend.getUsername()}</a></td>
                                            <td>${friend.getCreatedDate()}</td>
                                        </tr>
                                    </#list>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</@layout.page>