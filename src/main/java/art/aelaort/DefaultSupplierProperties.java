package art.aelaort;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@AllArgsConstructor
public class DefaultSupplierProperties implements SupplierProperties {
	private String s3File;
	private String s3Bucket;
}
