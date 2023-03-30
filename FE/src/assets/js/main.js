window.onload = function () {
  /* Authen modal */

  var modal = document.getElementById("modal");

  var modalOverlay = document.getElementById("modalOverlay");

  modalOverlay.onclick = function () {
    loginModal.style.display = "none";
    registerModal.style.display = "none";
    modal.style.display = "none";
  }

  /* Login modal */

  var loginLinkInside = document.getElementById("loginLinkInside");

  var loginModal = document.getElementById("loginModal");

  var loginLink = document.getElementById("loginLink");

  loginLink.onclick = function () {
    modal.style.display = "flex";
    loginModal.style.display = "block";
  }

  loginLinkInside.onclick = function () {
    registerModal.style.display = "none";
    loginModal.style.display = "block";
  }

  /* Register modal */

  var registerLinkInside = document.getElementById("registerLinkInside");

  var registerModal = document.getElementById("registerModal");

  var registerLink = document.getElementById("registerLink");

  registerLink.onclick = function () {
    modal.style.display = "flex";
    registerModal.style.display = "block";
  }

  registerLinkInside.onclick = function () {
    loginModal.style.display = "none";
    registerModal.style.display = "block";
  }
};
