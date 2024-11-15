package art.aelaort;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import software.amazon.awssdk.services.s3.S3Client;

import static art.aelaort.S3ClientProvider.client;

@AllArgsConstructor
public class YandexIAMSupplier {
	private RestTemplate yandexRestTemplate;
	private YandexIAMConfig yandexIAMConfig;

	public String getToken() {
		yandexRestTemplate.postForObject(
				yandexIAMConfig.funcUri(),
				new HttpEntity<>(yandexIAMConfig.funcSecret()),
				String.class
		);
		return readRemoteToken();
	}

	private String readRemoteToken() {
		try (S3Client client = client(yandexIAMConfig.s3Params())) {
			return client.getObjectAsBytes(builder -> builder
							.key(yandexIAMConfig.s3File())
							.bucket(yandexIAMConfig.s3Bucket()))
					.asUtf8String();
		}
	}
}
