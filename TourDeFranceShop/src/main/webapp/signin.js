function signin() {
    let uname = document.querySelector("#username").value;
    let passwd = document.querySelector("#password").value;
    let formData = { username: uname, password: passwd }
    $.ajax({
        method: "POST",
        url: "bikeshop/loginservice/login",
        data: JSON.stringify(formData),
        contentType: "application/json",
        success: function (result) {
            sessionStorage.setItem("uid", result[0].uid);
            sessionStorage.setItem("role", result[0].role);
            alert(result[0].username + " has logged on");
        },
        error: function (error) {
            alert("something wrong");
            console.log(error);
        }
    });
}