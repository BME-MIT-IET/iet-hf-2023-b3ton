function osszehasonlit {
	param (
		$file
	)
	cat ./test_inputs/$file |
		java -classpath bin projlab.Prototype |
			Out-String |
				Set-Content ./test_run/$file
	fc.exe /a /l /w /n ".\test_run\$file" ".\test_outputs\$file"
}

$files = @(Get-ChildItem ./test_inputs/)
if ( $args.count -eq 0) {
	foreach ($file in $files) {
		osszehasonlit($file)
	}
}
else {
	osszehasonlit($args[0])
}