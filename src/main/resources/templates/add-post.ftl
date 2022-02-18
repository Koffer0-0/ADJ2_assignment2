<#import "parts/layout.ftl" as layout>
<@layout.page>
        <div class="page-body">
          <div class="container-fluid">
            <div class="page-header">
              <div class="row">
                <div class="col-lg-6 main-header">
                  <h2>Add<span>Post</span></h2>
                  <h6 class="mb-0">admin panel</h6>
                </div>
                <div class="col-lg-6 breadcrumb-right">
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="/"><i class="pe-7s-home"></i></a></li>
                    <li class="breadcrumb-item">Apps    </li>
                    <li class="breadcrumb-item">Blog</li>
                    <li class="breadcrumb-item active">Add Post</li>
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
                    <h5>Post Edit</h5>
                  </div>
                  <div class="card-body add-post">
                    <form id="add-post-form" class="row needs-validation themeform" novalidate="" action="/create-post" method="post">
                      <div class="col-sm-12">
                        <div class="form-group">
                          <label for="validationCustom01">Title:</label>
                          <input class="form-control" id="validationCustom01" name="postTitle" type="text" placeholder="Post Title" required="">
                          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                          <div class="valid-feedback">Looks good!</div>
                        </div>
                        <div class="form-group">

                        </div>
                        <div class="form-group">
                          <label>Post visibility:</label>
                          <div class="m-checkbox-inline">
                            <label for="edo-ani">
                              <input class="radio_animated" id="edo-ani" type="radio" name="postVisibility" checked="" value="VISIBLE_TO_ALL">All
                            </label>
                            <label for="edo-ani1">
                              <input class="radio_animated" id="edo-ani1" type="radio" name="postVisibility" value="VISIBLE_TO_USERS">Authorized
                            </label>
                            <label for="edo-ani2">
                              <input class="radio_animated" id="edo-ani2" type="radio" name="postVisibility" value="VISIBLE_TO_FRIENDS">Friends
                            </label>
                          </div>
                        </div>
                        <div class="form-group">
                          <label>Comments settings:</label>
                          <div class="m-checkbox-inline">
                            <label for="edo-an3">
                              <input class="radio_animated" id="edo-ani3" type="radio" name="commentsEnabled" checked="" value="true">Enabled
                            </label>
                            <label for="edo-ani4">
                              <input class="radio_animated" id="edo-ani4" type="radio" name="commentsEnabled" value="false">Disabled
                            </label>
                          </div>
                        </div>
                        <div class="form-group">
                          <label for="text-box">Post text:</label>
                          <textarea id="text-box" name="postText" rows="4"></textarea>
                        </div>
                      </div>
                    </form>
                    <div class="btn-showcase">
                      <button form="add-post-form" class="btn btn-primary btn-pill" type="submit">Post</button>
                      <input form="add-post-form" class="btn btn-light btn-pill" type="reset" value="Discard">
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- Container-fluid Ends-->
        </div>
</@layout.page>