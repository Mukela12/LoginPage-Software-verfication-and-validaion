const form = document.querySelector("form"),
  fnameField = form.querySelector(".fname-field"),
  fnameInput = fnameField.querySelector(".firstname"),
  lnameField = form.querySelector(".lname-field"),
  lnameInput = lnameField.querySelector(".lastname"),
    unameField = form.querySelector(".uname-field"),
    unameInput = unameField.querySelector(".username"),
  passField = form.querySelector(".create-password"),
  passInput = passField.querySelector(".password"),
  cPassField = form.querySelector(".confirm-password"),
  cPassInput = cPassField.querySelector(".cPassword");

// Email Validtion
function checkFName() {
  const fnamePattern = /^[\s\S]*.*[^\s][\s\S]*$/;
  if (!fnameInput.value.match(fnamePattern)) {
    return fnameField.classList.add("invalid"); //adding invalid class if email value do not mathced with email pattern
  }
  fnameField.classList.remove("invalid"); //removing invalid class if email value matched with emaiPattern
}

function checkLName() {
  const lnamePattern = /^[\s\S]*.*[^\s][\s\S]*$/;
  if (!lnameInput.value.match(lnamePattern)) {
    return lnameField.classList.add("invalid"); //adding invalid class if email value do not mathced with email pattern
  }
  lnameField.classList.remove("invalid"); //removing invalid class if email value matched with emaiPattern
}

function checkUName() {
  const unamePattern = /^[\s\S]*.*[^\s][\s\S]*$/;
  if (!unameInput.value.match(unamePattern)) {
    return unameField.classList.add("invalid"); //adding invalid class if email value do not mathced with email pattern
  }
  unameField.classList.remove("invalid"); //removing invalid class if email value matched with emaiPattern
}

// Hide and show password
const eyeIcons = document.querySelectorAll(".show-hide");

eyeIcons.forEach((eyeIcon) => {
  eyeIcon.addEventListener("click", () => {
    const pInput = eyeIcon.parentElement.querySelector("input"); //getting parent element of eye icon and selecting the password input
    if (pInput.type === "password") {
      eyeIcon.classList.replace("bx-hide", "bx-show");
      return (pInput.type = "text");
    }
    eyeIcon.classList.replace("bx-show", "bx-hide");
    pInput.type = "password";
  });
});

// Password Validation
function createPass() {
  const passPattern =
    /^(?=.*[*.?+$^(){}|\\/]{1})(?=.*\d{4})(?=.*[a-zA-Z]{4}).{9}$/;

	
  if (!passInput.value.match(passPattern)) {
    return passField.classList.add("invalid"); //adding invalid class if password input value do not match with passPattern
  }
  passField.classList.remove("invalid"); //removing invalid class if password input value matched with passPattern
}

// Confirm Password Validtion
function confirmPass() {
  if (passInput.value !== cPassInput.value || cPassInput.value === "") {
    return cPassField.classList.add("invalid");
  }
  cPassField.classList.remove("invalid");
}

// Calling Funtion on Form Sumbit
form.addEventListener("submit", (e) => {
  e.preventDefault(); //preventing form submitting
  checkFName();
  checkLName();
  checkUName();
  createPass();
  confirmPass();

  //calling function on key up
  fnameInput.addEventListener("keyup", checkFName);
 lnameInput.addEventListener("keyup", checkLName);
 unameInput.addEventListener("keyup", checkUName);
  passInput.addEventListener("keyup", createPass);
  cPassInput.addEventListener("keyup", confirmPass);

  if (
    !fnameField.classList.contains("invalid") &&
   !lnameField.classList.contains("invalid") &&
   !unameField.classList.contains("invalid") &&
    !passField.classList.contains("invalid") &&
    !cPassField.classList.contains("invalid")
  ) {
    location.href = form.getAttribute("action");
  }
});
