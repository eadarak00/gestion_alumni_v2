// const TOKEN_KEY = 'accessToken';
// const REFRESH_TOKEN_KEY = 'refreshToken';
// const USER_KEY = 'user';

// export const tokenManager = {
//   getAccessToken: () => {
//     return localStorage.getItem(TOKEN_KEY);
//   },

//   setAccessToken: (token) => {
//     localStorage.setItem(TOKEN_KEY, token);
//   },

//   getRefreshToken: () => {
//     return localStorage.getItem(REFRESH_TOKEN_KEY);
//   },

//   setRefreshToken: (token) => {
//     localStorage.setItem(REFRESH_TOKEN_KEY, token);
//   },

//   getUser: () => {
//     const userStr = localStorage.getItem(USER_KEY);
//     return userStr ? JSON.parse(userStr) : null;
//   },

//   setUser: (user) => {
//     localStorage.setItem(USER_KEY, JSON.stringify(user));
//   },

//   clearAll: () => {
//     localStorage.removeItem(TOKEN_KEY);
//     localStorage.removeItem(REFRESH_TOKEN_KEY);
//     localStorage.removeItem(USER_KEY);
//   },

//   isAuthenticated: () => {
//     return !!localStorage.getItem(TOKEN_KEY);
//   }
// };



const TOKEN_KEY = 'accessToken';
const REFRESH_TOKEN_KEY = 'refreshToken';
const USER_KEY = 'user';

export const tokenManager = {
  getAccessToken: () => localStorage.getItem(TOKEN_KEY),

  setAccessToken: (token) => {
    if (token) {
      localStorage.setItem(TOKEN_KEY, token);
    } else {
      localStorage.removeItem(TOKEN_KEY);
    }
  },

  getRefreshToken: () => localStorage.getItem(REFRESH_TOKEN_KEY),

  setRefreshToken: (token) => {
    if (token) {
      localStorage.setItem(REFRESH_TOKEN_KEY, token);
    } else {
      localStorage.removeItem(REFRESH_TOKEN_KEY);
    }
  },

  getUser: () => {
    try {
      const userStr = localStorage.getItem(USER_KEY);
      if (!userStr) return null;
      const user = JSON.parse(userStr);
      // ✅ VALIDATION MINIMALE
      return user && user.email && user.role ? user : null;
    } catch (error) {
      console.warn('TokenManager: Invalid user data in localStorage', error);
      localStorage.removeItem(USER_KEY);
      return null;
    }
  },

  setUser: (user) => {
    if (user && user.email && user.role) {
      try {
        localStorage.setItem(USER_KEY, JSON.stringify(user));
      } catch (error) {
        console.warn('TokenManager: Failed to save user', error);
        localStorage.removeItem(USER_KEY);
      }
    } else {
      localStorage.removeItem(USER_KEY);
    }
  },

  clearAll: () => {
    localStorage.removeItem(TOKEN_KEY);
    localStorage.removeItem(REFRESH_TOKEN_KEY);
    localStorage.removeItem(USER_KEY);
  },

  isAuthenticated: () => !!localStorage.getItem(TOKEN_KEY),
};
