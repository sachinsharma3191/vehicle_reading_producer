package com.egen.utils;

public class ErrorConstants {
	// Exception Error Messages
	public static final String MALFORMED_JSON = "MALFORMED_JSON";
	public static final String VALIDATION_ERROR = "VALIDATION_ERROR";
	public static final String LOGIN_ERROR = "LOGIN_ERROR";
	public static final String PARSE_EXCEPTION_ERROR = "PARSE_EXCEPTION_ERROR";
	public static final String IO_EXCEPTION_ERROR = "IO_EXCEPTION_ERROR";
	public static final String INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR";
	public static final String EMAIL_ERROR = "EMAIL_SERVICE_ERROR";
	public static final String EMAIL_SUCESS_MESSAGE = "Email Sent";
	public static final String AMAZON_S3_SERVICE_ERROR = "AMAZON_S3_SERVICE_ERROR";
	public static final String SEARCH_SERVICE_ERROR = "SEARCH_SERVICE_ERROR";
	public static final String VALIDATION_SERVICE_ERROR = "VALIDATION_SERVICE_ERROR";
	public static final String ADMIN_SERVICE_ERROR = "ADMIN_SERVICE_ERROR";
	public static final String FILE_STORAGE_ERROR = "FILE_STORAGE_ERROR";
	public static final String ZIP_ERROR = "ZIP_ERROR";
	public static final String BAD_REQUEST = "BAD_REQUEST";
	public static final String CSV_SERVICE_ERROR = "CSV_SERVICE_ERROR";

	// Validation Error Messages
	public static final String EMPTY_NUMBER_OF_IDS = "Kindly Provide Number of Ids";
	public static final String EMPTY_USER_NAME = "Kindly provide username to generate ids";
	public static final String INVALID_NUMBER = "Number of Ids should be greater than 0";
	public static final String EMPTY_KIT_NAME = "Kindly Provide Kit Name";
	public static final String EMPTY_ENVIRONMENT = "Please provide environment for Ids Generation";
	public static final String EMPTY_EMAIL_IDS = "Kindly Provide Email List";
	public static final String INVALID_EMAIL = "Kindly provide Valid Email";
	public static final String INVALID_DATE_RANGE = "Start Date should be before End Date";
	public static final String EMPTY_PRODUCT_IDS = "Please provide product ids";
	public static final String EMPTY_CREATION_DATE = "Please provide creation date";
	public static final String EMPTY_CREATED_BY = "Please provide author name";
	public static final String EMPTY_CREATION_DATE_RANGE = "Please provide date range";
	public static final String EMPTY_START_DATE = "Please provide start date";
	public static final String EMPTY_END_DATE = "Please provide end date";
	public static final String EMPTY_LIST = "Kindly provide Test Name and Prefix Id for Tube Id";
	public static final String EMPTY_OBJECT = "Kindly provide Test Name and Prefix Id for Tube Id";
	public static final String EMPTY_TEST = "Kindly provide Test Name";
	public static final String EMPTY_TUBE_PREFIX = "Kindly provide Prefix for Tube Id";
	public static final String UPPER_CASE = " must be in Capital Letter";
	public static final String TEST_EXISTS = "Test Exists";
	public static final String TEST_NOT_EXISTS = "Test doesn't Exist";
	public static final String NO_TEST_PRESENT = "No Tests is present";
	public static final Integer MINIMUM_TEST_PRESENT = 1;
}
