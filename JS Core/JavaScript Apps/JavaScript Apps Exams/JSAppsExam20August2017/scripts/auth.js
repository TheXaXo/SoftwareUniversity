let auth = (() => {
    function isAuthed() {
        return sessionStorage.getItem('authtoken') !== null;
    }

    function saveSession(data) {
        sessionStorage.setItem('username', data.username);
        sessionStorage.setItem('id', data._id);
        sessionStorage.setItem('authtoken', data._kmd.authtoken);
    }

    function login(username, password) {
        return remote.post('user', 'login', {username, password}, 'basic');
    }

    function register(username, password) {
        return remote.post('user', '', {username, password}, 'basic');
    }

    function logout() {
        return remote.post('user', '_logout', {authtoken: sessionStorage.getItem('authtoken')});
    }

    return {
        saveSession, login, register, logout, isAuthed
    }
})();