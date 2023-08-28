let currentUser = "";

fetch("http://localhost:8080/api/users/current").then(res => res.json())
    .then(data => {
        currentUser = data;
        console.log(data)
        showOneUser(currentUser);
        showEmailAndRoles(currentUser);
    })

function showEmailAndRoles(user) {
    const usernameElement = document.getElementById("usernameAuth");
    const rolesElement = document.getElementById("rolesAuth");
    const rolesString = user.roles.map(role => role.name.replace("ROLE_", "")).join(", ");
    usernameElement.textContent = user.username;
    rolesElement.textContent = rolesString;
}

function showOneUser(user) {
    let temp = "";
    temp += "<tr>"
    temp += "<td>" + user.id + "</td>"
    temp += "<td>" + user.firstName + "</td>"
    temp += "<td>" + user.lastName + "</td>"
    temp += "<td>" + user.age + "</td>"
    temp += "<td>" + user.email + "</td>"
    temp += "<td>" + user.roles.map(role => role.name.substring(5)) + "</td>"
    temp += "</tr>"
    document.getElementById("oneUserBody").innerHTML = temp;
}