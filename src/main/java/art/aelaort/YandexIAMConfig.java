package art.aelaort;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.net.URI;

@Getter
@Setter
@Component
@ConfigurationProperties("yandex.iams3")
public class YandexIAMConfig {
	private String s3Id;
	private String s3Key;
	private String s3Url;
	private String s3Region;

	private String s3File;
	private String s3Bucket;

	private String funcSecret;
	private URI funcUrl;

	public S3Params s3Params() {
		return new DefaultS3Params(s3Id, s3Key, s3Url, s3Region);
	}
}
