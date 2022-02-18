<#import "parts/layout.ftl" as layout>
<@layout.page>
    <div class="page-body" style="background: #FAF0E6">
        <div class="container-fluid">
            <div class="page-header">
                <div class="row">
                    <div class="col-lg-6 main-header">
                        <h2 style="color: orange">${user.getUsername()}'s Blog</h2>
                        <h6 class="mb-0" style="color: orange">admin panel</h6>
                    </div>
                    <div class="col-lg-6 breadcrumb-right">
                        <ol class="breadcrumb">
                            <li><a href="/"><p style="color: orange">Home / </p></a></li>
                            <li><p style="color: orange">Apps /</p></li>
                            <li><p style="color: orange">Blog /</p></li>
                            <li><p style="color: orange">Blog Single</p></li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>

        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-12">
                    <form id="set-page-visibility" action="/set-page-visibility" method="post">
                        <input type="hidden" name="username" value="${user.getUsername()}">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <div class="form-group">
                            <label>Page visibility:</label>
                            <!-- TODO: learn to not shitcode xd -->
                            <div class="m-checkbox-inline">
                                <label for="edo-ani">
                                    <input id="edo-ani" type="radio"
                                           name="pageVisibility" <#if user.getPageVisibility().ordinal() == 2> checked=""</#if>
                                           value="VISIBLE_TO_ALL">All
                                </label>
                                <label for="edo-ani1">
                                    <input id="edo-ani1" type="radio"
                                           name="pageVisibility" <#if user.getPageVisibility().ordinal() == 1> checked=""</#if>
                                           value="VISIBLE_TO_USERS">Authorized
                                </label>
                                <label for="edo-ani2">
                                    <input id="edo-ani2" type="radio"
                                           name="pageVisibility" <#if user.getPageVisibility().ordinal() == 0> checked=""</#if>
                                           value="VISIBLE_TO_FRIENDS">Friends
                                </label>
                            </div>
                            <!-- shitcode -->
                        </div>
                    </form>
                    <div class="btn-showcase">
                        <button form="set-page-visibility"
                                class="btn btn-pill" style="background: orange" type="submit">Save
                        </button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Container-fluid starts-->
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-12">
                    <#if posts?size == 0>
                        <p>No posts yet</p>
                    <#else>
                        <#list posts as post>
                            <div class="blog-single">
                                <div class="blog-box blog-details">
                                    <div class="blog-details">
                                        <ul class="blog-social">
                                            <li class="digits">${post.getCreatedDate()}</li>
                                            <li>
                                                <i class="icofont icofont-user"></i><span>${post.getPostAuthor().getUsername()} </span>
                                            </li>
                                            <li class="digits"><i class="icofont icofont-thumbs-up"></i>02
                                                <span>Hits</span></li>
                                            <li class="digits"><i
                                                        class="icofont icofont-ui-chat"></i>${post.getComments()?size}
                                                Comments |
                                                <#if post.commentsEnabled>
                                                    <a style="color: orangered"
                                                       href="/post-set-comments?postId=${post.getId()}&commentsEnabled=false">Disable</a>
                                                <#else>
                                                    <a style="color: orangered"
                                                       href="/post-set-comments?postId=${post.getId()}&commentsEnabled=true">Enable</a>
                                                </#if>
                                            </li>
                                        </ul>
                                        <h4>
                                            ${post.getPostTitle()}
                                        </h4>
                                        <div class="single-blog-content-top">
                                            <p>${post.postText}</p>
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
                                                    <div class="media"><img class="align-self-center"
                                                                            src="/images/blog/14.png"
                                                                            alt="Generic placeholder image">
                                                        <div class="media-body">
                                                            <div class="row">
                                                                <div class="col-md-4">
                                                                    <h6 class="mt-0">${comment.getCommentAuthor().getUsername()}
                                                                        <span> ( ${comment.getCreatedDate()} )</span>
                                                                    </h6>
                                                                </div>
                                                                <div class="col-md-8">
                                                                    <ul class="comment-social float-left float-md-right">
                                                                        <li class="digits"><i
                                                                                    class="icofont icofont-thumbs-up"></i>02
                                                                            Hits
                                                                        </li>
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
                                                        class="btn btn-pill" style="background: orange" type="submit">
                                                    Post
                                                </button>
                                                <input form="add-comment-form-${post_index}"
                                                       class="btn btn-light btn-pill" type="reset" value="Discard">
                                            </div>
                                        </div>
                                    </#if>
                                </section>
                            </div>
                        </#list>
                    </#if>
                </div>
            </div>
        </div>
    </div>
</@layout.page>