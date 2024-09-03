package art.aelaort;

import java.net.URI;

public interface SupplierProperties {
	URI funcUrl();
	String funcSecret();
	String s3File();
	String s3Bucket();
}
