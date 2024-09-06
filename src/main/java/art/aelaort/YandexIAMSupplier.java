package art.aelaort;

import art.aelaort.ya.func.helper.FuncParams;
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
	private FuncParams funcParams;

	public String getToken() {
		yandexRestTemplate.postForObject(
				funcParams.uri(),
				new HttpEntity<>(funcParams.secret()),
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
