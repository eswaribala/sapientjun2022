// Import.
const log = require('log-to-file');

// Save log to default log file "default.log".
log('Some data');

// Save log to custom log file "my-log.log".
log('Another data', 'my-log2022.log');

// Save log to custom log file "my-log.log" with delimiter "\r\n" (default delimiter "\n").
log('Another data', 'my-log2021.log', '\r\n');
