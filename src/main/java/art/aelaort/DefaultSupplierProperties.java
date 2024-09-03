package art.aelaort;

public class DefaultSupplierProperties implements SupplierProperties {
	private String funcUrl;
	private String funcSecret;
	private String s3File;
	private String s3Bucket;

	public DefaultSupplierProperties(String funcUrl, String funcSecret, String s3File, String s3Bucket) {
		this.funcUrl = funcUrl;
		this.funcSecret = funcSecret;
		this.s3File = s3File;
		this.s3Bucket = s3Bucket;
	}

	public String funcUrl() {
		return funcUrl;
	}

	public String funcSecret() {
		return funcSecret;
	}

	public String s3File() {
		return s3File;
	}

	public String s3Bucket() {
		return s3Bucket;
	}
}
