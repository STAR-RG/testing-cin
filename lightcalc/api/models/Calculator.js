/**
* Calculator.js
*
* @description :: TODO: You might write a short summary of how this model works and what it represents here.
* @docs        :: http://sailsjs.org/#!documentation/models
*/

module.exports = {
	attributes: {
		name: {
			type: 'STRING',
			required: true,
			unique: true,
			alphanumeric: true,
			minLength: 8,
			maxLength: 40
		},
		operations: {
			collection: 'operation',
			via: 'calculator'
	    }
	}
};

