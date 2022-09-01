const { defineConfig } = require("cypress");

module.exports = defineConfig({
  fixturesFolder: false,
  video: false,

  component: {
    setupNodeEvents(on, config) {},
    specPattern: "src/**/*spec.{js,jsx,ts,tsx}",
  },

  e2e: {
    setupNodeEvents(on, config) {
      // implement node event listeners here
    },
  },
});
