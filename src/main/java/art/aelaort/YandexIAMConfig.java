package art.aelaort;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.net.URI;

@AllArgsConstructor
@Getter
@Accessors(fluent = true)
public class YandexIAMConfig {
	private String s3Id;
	private String s3Key;
	private String s3Url;
	private String s3Region;

	private String s3File;
	private String s3Bucket;

	private String funcSecret;
	private URI funcUri;

	public S3Params s3Params() {
		return new DefaultS3Params(s3Id, s3Key, s3Url, s3Region);
	}
}
