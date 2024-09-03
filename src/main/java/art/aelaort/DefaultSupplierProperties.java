package art.aelaort;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.net.URI;

@Getter
@Accessors(fluent = true)
@AllArgsConstructor
public class DefaultSupplierProperties implements SupplierProperties {
	private URI funcUrl;
	private String funcSecret;
	private String s3File;
	private String s3Bucket;
}
