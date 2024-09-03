package art.aelaort;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import software.amazon.awssdk.services.s3.S3Client;

import static art.aelaort.S3ClientProvider.client;

@AllArgsConstructor
public class YandexIAMSupplier {
	private RestTemplate yandexRestTemplate;
	private S3Params yandexS3Params;
	private SupplierProperties properties;

	public String getToken() {
		yandexRestTemplate.postForObject(
				properties.funcUrl(),
				new HttpEntity<>(properties.funcSecret()),
				String.class
		);
		return readRemoteToken();
	}

	private String readRemoteToken() {
		try (S3Client client = client(yandexS3Params)) {
			return client.getObjectAsBytes(builder -> builder
							.key(properties.s3File())
							.bucket(properties.s3Bucket()))
					.asUtf8String();
		}
	}
}
