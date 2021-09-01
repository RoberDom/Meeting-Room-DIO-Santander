const PROXY_CONFIG = [
	{
	context:'/api/v1/rooms',
	target:'http://localhost:8082',
	secure: false,
	logLevel: 'debug',

}

];

module.exports = PROXY_CONFIG;
