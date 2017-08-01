function attachEvents() {
    let loadPostsButton = $("#btnLoadPosts");
    let postsSelectField = $("#posts");
    let viewPostButton = $("#btnViewPost");

    loadPostsButton.on("click", loadPosts);
    viewPostButton.on("click", viewPost);

    function makeRequest(end) {
        return $.ajax({
            url: `https://baas.kinvey.com/appdata/kid_Sk5LBTaUb/${end}`,
            headers: {"Authorization": `Basic ${btoa("admin:admin")}`}
        })
    }

    function loadPosts() {
        makeRequest("posts").then(renderPosts);

        function renderPosts(data) {
            postsSelectField.empty();

            for (let post of data) {
                postsSelectField.append(`<option value="${post._id}">${post.title}</option>`);
            }
        }
    }

    function viewPost() {
        let postId = postsSelectField.find("option:selected")[0].value;

        let getPost = makeRequest(`posts/${postId}`);
        let getComments = makeRequest(`comments/?query={"post_id": "${postId}"}`);

        Promise.all([getPost, getComments]).then(renderPostAndComments);

        function renderPostAndComments(data) {
            let post = data[0];
            let comments = data[1];

            $("#post-title").text(post.title);
            $("#post-body").text(post.body);

            let postComments = $("#post-comments");
            postComments.empty();

            for (let comment of comments) {
                postComments.append(`<li>${comment.text}</li>`);
            }
        }
    }
}