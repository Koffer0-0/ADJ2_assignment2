<#import "parts/layout.ftl" as layout>
<@layout.page>
    <div class="page-body">
        <div class="container-fluid">
            <div class="page-header">
                <div class="row">
                    <div class="col-lg-6 main-header">
                        <h2>Blogs<span></span></h2>
                        <h6 class="mb-0">posts of users</h6>
                    </div>
                    <div class="col-lg-6 breadcrumb-right">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="/"><i class="pe-7s-home"></i></a></li>
                            <li class="breadcrumb-item">Blogs</li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>
        <!-- Container-fluid starts-->
        <div class="container-fluid">
            <div class="row">
                <#list posts as post>
                <div class="col-md-6 col-xl-3 box-col-6">
                    <div class="card">
                        <div class="blog-box blog-grid text-center"><img class="img-fluid top-radius-blog" src="/images/blog/blog-6.jpg" alt="">
                            <div class="blog-details-main">
                                <ul class="blog-social">
                                    <li class="digits">${post.getCreatedDate()}</li>
                                    <li class="digits">by: <a href="/user/${post.getPostAuthor().getUsername()}">${post.getPostAuthor().getUsername()}</a></li>
                                    <li class="digits">0 Hits</li>
                                </ul>
                                <hr>
                                <h6 class="blog-bottom-details">${post.getPostTitle()}</h6>
                            </div>
                        </div>
                    </div>
                </div>
                </#list>
                <#if posts?size == 0>
                <div class="col-md-6 col-xl-3 box-col-6">
                    <p>No posts yet</p>
                </div>
                </#if>
            </div>
        </div>
    </div>
</@layout.page>
