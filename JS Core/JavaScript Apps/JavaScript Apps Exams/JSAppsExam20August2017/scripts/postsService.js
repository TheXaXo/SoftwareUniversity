let postsService = (() => {
    function loadPosts() {
        return remote.get('appdata', 'posts', 'kinvey');
    }

    function createPost(author, url, title, imageUrl, description) {
        let postData = {
            author,
            url,
            title,
            imageUrl,
            description
        };

        return remote.post('appdata', 'posts', postData, 'kinvey');
    }

    function loadPostDetails(id) {
        return remote.get('appdata', 'posts/' + id, 'kinvey');
    }

    function loadUserPosts() {
        return remote.get('appdata', `posts?query={"author":"${sessionStorage.getItem("username")}"}&sort={"_kmd.ect": -1}`, 'kinvey');
    }

    function edit(id, url, title, imageUrl, description) {
        let postData = {
            author: sessionStorage.getItem('username'),
            title,
            url,
            imageUrl,
            description
        };

        return remote.update('appdata', 'posts/' + id, postData, 'kinvey');
    }

    function remove(id) {
        return remote.del('appdata', 'posts/' + id, 'kinvey');
    }

    function loadPostComments(id) {
        return remote.get('appdata', `comments?query={"postId":"${id}"}&sort={"_kmd.ect": -1}`, 'kinvey');
    }

    function createComment(postId, content) {
        let commentData = {
            author: sessionStorage.getItem("username"),
            content,
            postId
        };

        return remote.post('appdata', 'comments', commentData, 'kinvey');
    }

    function deleteComment(commentId) {
        return remote.del('appdata', 'comments/' + commentId, 'kinvey');
    }

    function getCommentDetails(commentId) {
        return remote.get('appdata', 'comments/' + commentId, 'kinvey');
    }

    return {
        loadPosts,
        createPost,
        loadPostDetails,
        loadUserPosts,
        loadPostComments,
        edit,
        remove,
        createComment,
        deleteComment,
        getCommentDetails
    }
})();