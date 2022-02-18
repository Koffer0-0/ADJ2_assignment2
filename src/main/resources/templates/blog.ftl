<#import "parts/layout.ftl" as layout>
<@layout.page>
    <div class="page-body">
        <div class="container-fluid">
            <div class="page-header">
                <div class="row">
                    <div class="col-lg-6 main-header">
                        <#--                  <h2>Blog<span>Single</span></h2>-->
                        <h2>${user.getUsername()}'s Blog</h2>
                        <h6 class="mb-0">admin panel</h6>
                    </div>
                    <div class="col-lg-6 breadcrumb-right">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="/"><i class="pe-7s-home"></i></a></li>
                            <li class="breadcrumb-item">Apps</li>
                            <li class="breadcrumb-item">Blog</li>
                            <li class="breadcrumb-item active">Blog Single</li>
                        </ol>
                    </div>
                </div>
                <br>
<#--                TODO: finish implementing this-->
                <#if (Session.SPRING_SECURITY_CONTEXT.authentication.principal.username)??>
                    <div class="row">
                        <p>Adding to friends doesn't work yet</p>
                        <form id="add-friend-form" action="/add-friend" method="post">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <input type="hidden" name="username" value="${user.getUsername()}">
                            <input type="hidden" name="">
                        </form>
                        <div class="col-lg-12 btn-showcase">
                            <button form="add-friend-form" class="btn btn-primary btn-pill"><i
                                        class="icofont icofont-people"></i> Add to friends
                            </button>
                        </div>
                    </div>
                </#if>
            </div>
        </div>
        <!-- Container-fluid starts-->
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-12">
                    <#if canSeePosts && posts?size == 0>
                        <p>No posts yet</p>
                    <#elseif canSeePosts>
                        <#list posts as post>
                            <div class="blog-single">
                                <div class="blog-box blog-details">
                                    <#--                      <img class="img-fluid w-100" src="/images/blog/blog-single.jpg" alt="blog-main">-->
                                    <div class="blog-details">
                                        <ul class="blog-social">
                                            <li class="digits">${post.getCreatedDate()}</li>
                                            <li>
                                                <i class="icofont icofont-user"></i><span>${post.getPostAuthor().getUsername()} </span>
                                            </li>
                                            <li class="digits"><i
                                                        class="icofont icofont-ui-chat"></i>${post.getComments()?size}
                                                Comments
                                            </li>
                                        </ul>
                                        <h4>
                                            ${post.getPostTitle()}
                                        </h4>
                                        <div class="single-blog-content-top">
                                            <p>${post.postText}</p>
                                            <#--                          <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>-->
                                            <#--                          <p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like</p>-->
                                        </div>
                                    </div>
                                </div>
                                <section class="comment-box">
                                    <h4>Comment</h4>
                                    <hr>
                                    <#if post.getComments()?size == 0>
                                        <p>There are no comments yet. Be first!</p>
                                    <#else>
                                        <ul>
                                            <#list post.getComments() as comment>
                                                <li>
                                                    <div class="media">
                                                        <img class="align-self-center" src="/images/blog/14.png"alt="Generic placeholder image">
                                                        <div class="media-body">
                                                            <div class="row">
                                                                <div class="col-md-4">
                                                                    <h6 class="mt-0">${comment.getCommentAuthor().getUsername()}
                                                                        <span> ( ${comment.getCreatedDate()} )</span>
                                                                    </h6>
                                                                </div>
                                                                <div class="col-md-8">
                                                                    <ul class="comment-social float-left float-md-right">
                                                                    </ul>
                                                                </div>
                                                            </div>
                                                            <p>${comment.getCommentText()}</p>
                                                        </div>
                                                    </div>
                                                </li>
                                            </#list>
                                        </ul>
                                    </#if>
                                    <#if post.isCommentsEnabled()>
                                        <div class="card-body add-post">
                                            <form id="add-comment-form-${post_index}"
                                                  class="row needs-validation themeform" novalidate=""
                                                  action="/create-comment" method="post">
                                                <div class="col-sm-12">
                                                    <input type="hidden" name="${_csrf.parameterName}"
                                                           value="${_csrf.token}"/>
                                                    <input type="hidden" name="postId" value="${post.getId()}">
                                                    <input type="hidden" name="continueTo" value="${__SELF}">
                                                    <div class="form-group">
                                                        <label for="text-box">Comment text:</label>
                                                        <textarea id="text-box" name="commentText" rows="4"></textarea>
                                                    </div>
                                                </div>
                                            </form>
                                            <div class="btn-showcase">
                                                <button form="add-comment-form-${post_index}"
                                                        class="btn btn-primary btn-pill" type="submit">Post
                                                </button>
                                                <input form="add-comment-form-${post_index}"
                                                       class="btn btn-light btn-pill" type="reset" value="Discard">
                                            </div>
                                        </div>
                                    </#if>
                                </section>
                            </div>
                        </#list>
                    <#else>
                        <p>You have no access to the posts</p>
                    </#if>
                </div>
            </div>
        </div>
    </div>
</@layout.page>