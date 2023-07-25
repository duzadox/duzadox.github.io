document.getElementById("loginBtn").addEventListener("click", function() {
  document.getElementById("popup").style.display = "block";
});

document.getElementsByClassName("close")[0].addEventListener("click", function() {
  document.getElementById("popup").style.display = "none";
});

document.getElementById("loginSwitchBtn").addEventListener("click", function() {
  document.getElementById("loginForm").style.display = "block";
  document.getElementById("registerForm").style.display = "none";
  document.getElementById("loginSwitchBtn").classList.add("active");
  document.getElementById("registerSwitchBtn").classList.remove("active");
});

document.getElementById("registerSwitchBtn").addEventListener("click", function() {
  document.getElementById("loginForm").style.display = "none";
  document.getElementById("registerForm").style.display = "block";
  document.getElementById("loginSwitchBtn").classList.remove("active");
  document.getElementById("registerSwitchBtn").classList.add("active");
});
  
// Array to store registered users
var registeredUsers = [];

// Function to register a user
function registerUser(username, password) {
  // Check if username already exists
  var existingUser = registeredUsers.find(function(user) {
    return user.username === username;
  });

  if (existingUser) {
    alert("Username already exists. Please choose a different username.");
    return;
  }

  // Add user to the registered users array
  registeredUsers.push({
    username: username,
    password: password
  });

  alert("Registration successful. You can now log in with your credentials.");
}

// Function to log in a user
function loginUser(username, password) {
  // Find user in the registered users array
  var user = registeredUsers.find(function(user) {
    return user.username === username && user.password === password;
  });

  if (user) {
    alert("Login successful. Welcome, " + user.username + "!");
    // Perform any additional actions after successful login
  } else {
    alert("Invalid username or password. Please try again.");
  }
}

// Event listeners for registration and login
document.getElementById("registerForm").addEventListener("submit", function(event) {
  event.preventDefault(); // Prevent form submission

  var username = document.getElementById("registerUsername").value;
  var password = document.getElementById("registerPassword").value;

  registerUser(username, password);
});

document.getElementById("loginForm").addEventListener("submit", function(event) {
  event.preventDefault(); // Prevent form submission

  var username = document.getElementById("loginUsername").value;
  var password = document.getElementById("loginPassword").value;

  loginUser(username, password);
});
s