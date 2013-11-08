apply plugin: 'java'

repositories {
    mavenCentral()
}

dependencies {
    compile group: 'commons-collections', 
                    name: 'commons-collections', 
                    version: '3.2'
    testCompile group: 'junit', 
                    name: 'junit', 
                    version: '4.+'
}

test {
    systemProperties 'sampleProperty': 'sampleValue'
}

version = '1.0'
jar {
    manifest {
        attributes 'Implementation-Title': 'Gradle Quickstart', 
                    'Implementation-Version': version
    }
}