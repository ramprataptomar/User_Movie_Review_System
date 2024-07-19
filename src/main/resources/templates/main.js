// Get User
document.getElementById("allUser").onclick = async (e) => {
    const response = await fetch('http://localhost:8080/user/getAll');

    if (response.status === 200) {
        let jsonBody = JSON.parse(await response.text())
        parseUserBody(jsonBody);
    }
}

function parseUserBody(userBody) {
    let table = document.getElementById("usertable");
    var tbody = table.getElementsByTagName("tbody")[0];
    while (tbody.firstChild) {
        tbody.removeChild(tbody.firstChild);
    }

    if(Array.isArray(userBody)) {
        for (let i= 0; i < userBody.length; i++) {
            addUserRowToTable(userBody[i]);
        }
    }
}

function renderData(user) {

}

function addUserRowToTable(user) {
    let table = document.getElementById("usertable");
    let tbody = table.getElementsByTagName("tbody")[0];
    let row = tbody.insertRow();
    let userId = row.insertCell(0);
    let userName = row.insertCell(1);
    let email = row.insertCell(2);
    let favoriteMovies = row.insertCell(3);
    let edit = row.insertCell(4);
    let deleteColumn = row.insertCell(5);

    userId.innerHTML = user.userId;
    userName.innerHTML = user.userName;
    email.innerHTML = user.email;
    favoriteMovies.innerHTML = user.favoriteMovies;

    let editBtn = document.createElement('button');
    editBtn.innerHTML = "Edit";
    edit.appendChild(editBtn);
    editBtn.addEventListener('click', () => {

    })

    let deleteBtn = document.createElement('button');
    deleteBtn.innerHTML = "Delete";
    deleteColumn.appendChild(deleteBtn);
    deleteBtn.addEventListener('click', () => {
        let abc = fetch(`http://localhost:8080/user/delete/${user.userId}`, {
            method: 'DELETE',
            headers: { 'Content-Type': 'application/json' }
        }) .then(response => {
            if (response.ok) {
                console.log('Data deleted successfully!');
                renderData(user);
            } else {
                console.error('Error deleting data:', response.statusText);
            }
        }) .catch(error => {
            console.error('Error making API request:', error);
        });
        // addUserRowToTable(abc);
    });
}

// Add User
document.getElementById("addUser").onclick = async() => {
    window.open("./new.html", "_self");

    const form = document.getElementById('addUserButton');
    console.log(form);
    form.addEventListener('onclick', (e)  => {
        e.preventDefault();
        let id = document.getElementById("id");
        let name = document.getElementById("name");
        let email = document.getElementById("email");
        let favoriteMovie = document.getElementById("favoriteMovie")
        console.log(id,name);
        let user = {
            id:id.value,
            name:name.value,
            email:email.value,
            favoriteMovie:favoriteMovie.value,
        }
        fetch('http://localhost:8080/user/add', {
            method:'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(user)
        }).then(response => {
            if (response.ok) {
                console.log('Data added successfully!');
                // renderData(user);
            } else {
                console.error('Error adding data:', response.statusText);
            }
        }) .catch(error => {
            console.error('Error making API request:', error);
        });
    })

}


// @ToDo : movie js code
document.getElementById("allMovies").onclick = async () => {
    const response = await fetch('http://localhost:8080/movie/getAll');

    if (response.status === 200) {
        let jsonBody = JSON.parse(await response.text())
        parseMovieBody(jsonBody);
        console.log(jsonBody);
    }
}

function parseMovieBody(movieBody) {
    let table = document.getElementById("movieTable");
    var tbody = table.getElementsByTagName("tbody")[0];
    while (tbody.firstChild) {
        tbody.removeChild(tbody.firstChild);
    }

    if(Array.isArray(movieBody)) {
        for (let i= 0; i < movieBody.length; i++) {
            addMovieRowToTable(movieBody[i]);
        }
    }
}

function addMovieRowToTable(movie) {
    let table = document.getElementById("movieTable");
    let tbody = table.getElementsByTagName("tbody")[0];
    let row = tbody.insertRow();
    let movieId = row.insertCell(0);
    let movieName = row.insertCell(1);
    let genre = row.insertCell(2);
    let releaseYear = row.insertCell(3);
    let rating = row.insertCell(4);
    let edit = row.insertCell(5);
    let deleteColumn = row.insertCell(6);

    movieId.innerHTML = movie.movieId;
    movieName.innerHTML = movie.movieName;
    genre.innerHTML = movie.genre;
    releaseYear.innerHTML = movie.releaseYear;
    rating.innerHTML = movie.rating;

    let editBtn = document.createElement('button');
    editBtn.innerHTML = "Edit";
    edit.appendChild(editBtn);
    editBtn.addEventListener('click', () => {

    })

    let deleteBtn = document.createElement('button');
    deleteBtn.innerHTML = "Delete";
    deleteColumn.appendChild(deleteBtn);
    deleteBtn.addEventListener('click', () => {
        fetch(`http://localhost:8080/movie/delete/${movie.movieId}`, {
            method: 'DELETE',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify()
        }) .then(response => {
            if (response.ok) {
                console.log('Data deleted successfully!');
            } else {
                console.error('Error deleting data:', response.statusText);
            }
        }) .catch(error => {
            console.error('Error making API request:', error);
        });
    });
}