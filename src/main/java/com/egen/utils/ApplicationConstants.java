package com.egen.utils;

import java.util.Arrays;
import java.util.List;

public class ApplicationConstants {

	private ApplicationConstants() {

	}

	// Application Constants

	public static final String KIT_ID_GEN_DOWNLOAD_REQUEST = "DOWNLOAD";
	public static final String KIT_ID_GEN_EMAIL_REQUEST = "EMAIL";

	public static final int PRODUCT_CODE_LENGTH = 12;
	public static final int TEST_PRODUCT_CODE_LENGTH = 14;

	public static final String VALID_CHARACTERS = "234689ACDEFHJKMNPRTVWXY";
	public static final String PRODUCT_SEPARATOR = "-";

	// Environment Information
	public static final String PROD_ENVIRONMENT = "PROD";
	public static final String UAT_ENVIRONMENT = "UAT";
	// FILE CONSTANTS
	public static final String JSON_FILE_EXTENSION = ".json";
	public static final String CSV_FILE_EXTENSION = ".csv";
	// CSV FILE CONSTANTS
	public static final String NEW_LINE_SEPARATOR = "\n";
	public static final String COMMA_SEPARATOR = ",";
	public static final String UNDERSCORE = "_";
	public static final String COLON = ":";
	public static final String SPACE = " ";
	public static final String SEPARATOR = "/";

	public static final String[] CSV_HEADERS = { "Id Type", "File Name", "Created By", "Created Date" };

	public static final String HYPHEN = "-";

	// HEADER FOR FULL FILE THESE HEADERS INFORMATION ARE MEANT FOR INTERNAL USERS
	public static final String CSV_FULL_HEADERS_WITH_TEST_SIZE_1 = "A,B,C,D";
	public static final String CSV_FULL_HEADERS_WITH_TEST_SIZE_2 = "A,B,C,D,E,F,G";
	public static final String CSV_FULL_HEADERS_WITH_TEST_SIZE_3 = "A,B,C,D,E,F,G,H,I,J";

	// HEADER FOR FILE THESE HEADERS INFORMATION ARE MEANT FOR EXTERNAL USERS
	public static final String CSV_HEADERS_WITH_TEST_SIZE_1 = "A,B,C,D";
	public static final String CSV_HEADERS_WITH_TEST_SIZE_2 = "A,B,C,D,E,F";
	public static final String CSV_HEADERS_WITH_TEST_SIZE_3 = "A,B,C,D,E,F,G,H";

	// DATE TIME CONSTANTS
	public static final String BUCKET_FOLDER_SEPARATOR = "/";
	public static final String DATE_FORMAT = "dd-MM-yyyy";
	public static final String ELASTIC_SEARCH_DATE_FORMAT = "yyyy-MM-dd";

	// AWS S3 BUCKET CONSTANTS
	public static final String BUCKET_PUBLIC_URL = "https://s3.console.aws.amazon.com/s3/object/";
	public static final String BUCKET_NAME = "viome-product-id-generator";
	public static final String FULL_BUCKET_URL = BUCKET_PUBLIC_URL + BUCKET_NAME;

	public static final String BUCKET_CONFIG_FOLDER = "config";
	public static final String BUCKET_PRODUCT_CODE_FOLDER = "productCode";
	public static final String BUCKET_PRODUCT_CODE_JSON_FOLDER = "productCodeJSON";
	/*
	 * 
	 * /**
	 * 
	 * @deprecated Use {@link #DATE_FORMAT} instead
	 */
	public static final String US_DATE_FORMAT = DATE_FORMAT;

	// AWS S3 BUCKET CONSTANTS
	public static final String S3_USER_METADATA_PREFIX = "x-amz-meta-";
	public static final String JSON_METADATA = "application/json";
	public static final String CREATED_DATE = S3_USER_METADATA_PREFIX + "created-date";
	public static final String CREATED_BY = S3_USER_METADATA_PREFIX + "created-by";
	public static final String PRODUCT_ID_SOURCE_FILE = S3_USER_METADATA_PREFIX + "product-id-source";

	// AWS ELASTIC SEARCH CONSTANTS
	public static final String[] INCLUDE_FIELDS = { "csvFileName", "author", "createdDate",
			"productTestIds.testIdInfo.testId", "productTestIds.tubeIdInfo.tubdIds", "kitIdInfo.kitId" };

	public static final Integer ELASTIC_SEARCH_RESULTS_SIZE = 999999999;
	/**
	 * @deprecated Use {@link #ELASTIC_SEARCH_RESULTS_SIZE} instead
	 */
	public static final Integer DEFAULT_RESULTS_SIZE = ELASTIC_SEARCH_RESULTS_SIZE;
	public static final String HYPEN = "-";

	public static final String VIOME_EXTERNAL = "Viome_External";
	public static final String VIOME_INTERNAL = "Viome_Internal";
	public static final String SEARCH_OPTIONS[] = { "id", "author", "date", "date range" };

	public static final String PRODUCT_ID_TYPES[] = { "Kit", "Test", "Tube" };

	public static final int THRESHOLD = 100000;

	public static final String VIOME_DOMAIN = "viome.com";
	// ELASTIC SEARCH CONSTANTS
	/**
	 * Elastic Search Index Storing Ids and their information
	 */
	public static final String ELASTIC_SEARCH_PRODUCT_ID_INDEX = "product-id";
	public static final String ELASTIC_SEARCH_DOC_TYPE = "_doc";
	/**
	 * Elastic Search Index Storing Ids for validation service
	 */
	public static final String ELASTIC_SEARCH_PRODUCT_IDS_INDEX = "product-ids";

	/**
	 * Index storing file name information of the ids generated
	 */
	public static final String ELASTIC_SEARCH_FILE_INDEX = "files_index";

	/**
	 * AWS Services for Elastic Search has payload limit of 10 MB per HTTP request.
	 * Setting Limit of 35000 Ids for creating index in Elastic Search
	 */
	public static final int AWS_ES_CREATE_INDEX_PAYLOAD_LIMIT = 35000;

	/**
	 * AWS Services for Elastic Search has payload limit of 10 MB per HTTP request
	 * Setting limit of 10000 Ids for validating product ids in Elastic Search.
	 */

	public static final int AWS_ES_VALIDATE_IDS_PAYLOAD_LIMIT = 10000;
	/**
	 * AWS Services for Email Service has attachment size limit of 10 MB for sending
	 * emails.Setting limit of 18000 Ids for attachments
	 */

	public static final int AWS_SES_PAYLOAD_LIMIT = 18000;

	/**
	 * PARALLELSIM LEVEL
	 */
	public static final int PARALLELISM = Runtime.getRuntime().availableProcessors();

	/**
	 * LOAD INDEXES INTO INDEX CACHE
	 */
	public static final List<String> LOAD_INDEXES = Arrays.asList(new String[] { ELASTIC_SEARCH_PRODUCT_ID_INDEX,
			ELASTIC_SEARCH_PRODUCT_IDS_INDEX, ELASTIC_SEARCH_FILE_INDEX });

	/**
	 * Buffer LIMIT TO Handle Duplicate Kit,Test and Tube Ids
	 */
	public static final int BUFFER_SIZE = 20;

	/**
	 * Constants for Ehcache
	 * 
	 */
	public static String VIOME_KIT_CACHE = "VIOME_KIT_CACHE";
	public static String VIOME_TEST_CACHE = "VIOME_TEST_CACHE";
	public static String VIOME_TEST_TUBE_PREFIX_CACHE = "VIOME_TEST_TUBE_PREFIX_CACHE";

	/**
	 * Admin Portal Constants
	 */
	public static final String ADMIN_FOLDER = "admin";
	public static final String VIOME_KIT = "ViomeKits";
	public static final String VIOME_TESTS = "ViomeTests";
	public static final String KIT_ID_BACKUP = "KitIdsBackup";

	public static final String KIT_ID_BACKUP_FOLDER = new StringBuilder().append(ADMIN_FOLDER).append(SEPARATOR)
			.append(KIT_ID_BACKUP).append(SEPARATOR).toString();

	//public static final String VIOME_TEST_S3_FILE = S3BucketConfiguration.getS3BucketDetails().getViomeTestsFile();
	// new StringBuilder().append(ADMIN_FOLDER).append(SEPARATOR)
	// .append(VIOME_TESTS).append(JSON_FILE_EXTENSION).toString();

	//public static final String VIOME_KIT_S3_FILE = S3BucketConfiguration.getS3BucketDetails().getViomeKitsFile();
	// new StringBuilder().append(ADMIN_FOLDER).append(SEPARATOR)
	// .append(VIOME_KIT).append(JSON_FILE_EXTENSION).toString();

	public static final String DELETE_VIOME_KIT_REQUEST = "DELETE_VIOME_KIT_REQUEST";
	public static final String CREATE_VIOME_KIT_REQUEST = "CREATE_VIOME_KIT_REQUEST";
	public static final String UPDATE_VIOME_KIT_REQUEST = "UPDATE_VIOME_KIT_REQUEST";
	public static final String CREATE_VIOME_TEST_REQUEST = "CREATE_VIOME_TEST_REQUEST";
	public static final String UPDATE_VIOME_TEST_REQUEST = "UDPATE_VIOME_TEST_REQUEST";

	public static final String FIRST_KIT_NOT_CREATED = "First Kit has not been created";
	public static final String FIRST_KIT_CREATED = "First Kit has been created";

	public static final String SPRING_PROFILES_ACTIVE = "SPRING_PROFILES_ACTIVE";

}
