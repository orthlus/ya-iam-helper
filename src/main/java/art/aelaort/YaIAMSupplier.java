package art.aelaort;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import software.amazon.awssdk.services.s3.S3Client;

import static art.aelaort.S3ClientProvider.client;

@RequiredArgsConstructor
public class YaIAMSupplier {
	private final RestTemplate yandexRestTemplate;
	private final SupplierProperties properties;
	private final S3Params yandexS3Params;

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
