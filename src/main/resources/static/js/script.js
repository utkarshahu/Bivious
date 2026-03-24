console.log("Script loaded");

// change theme work
let currentTheme = getTheme();
//initial -->

document.addEventListener("DOMContentLoaded", () => {
  changeTheme();
});

//TODO:
function changeTheme() {
  //set to web page

  changePageTheme(currentTheme, "");
  //set the listener to change theme button
  const changeThemeButton = document.querySelector("#theme_change_button");

  changeThemeButton.addEventListener("click", (event) => {
    let oldTheme = currentTheme;
    console.log("change theme button clicked");
    if (currentTheme === "dark") {
      //theme ko light
      currentTheme = "light";
    } else {
      //theme ko dark
      currentTheme = "dark";
    }
    console.log(currentTheme);
    changePageTheme(currentTheme, oldTheme);
  });
}

//set theme to localstorage
function setTheme(theme) {
  localStorage.setItem("theme", theme);
}

//get theme from localstorage
function getTheme() {
  let theme = localStorage.getItem("theme");
  return theme ? theme : "light";
}

//change current page theme
function changePageTheme(theme, oldTheme) {
  setTheme(theme);

  const htmlElement = document.querySelector("html");
  if (oldTheme) {
    htmlElement.classList.remove(oldTheme);
  }
  htmlElement.classList.add(theme);

  // Icon Change Logic
  const themeButton = document.querySelector("#theme_change_button");
  const icon = themeButton.querySelector("i");
  const span = themeButton.querySelector("span");

  if (theme === "light") {
    // Agar page light hai, toh button par "Moon" dikhao (Dark mode mein jaane ke liye)
    icon.className = "ri-moon-fill";
    
  } else {
    // Agar page dark hai, toh button par "Sun" dikhao (Light mode mein jaane ke liye)
    icon.className = "ri-sun-fill";
    
  }
}

//change page change theme