## Profile map

| Idea | Easy meaning |
| ---- | ------------ |
| Profile | Named set of POM properties/plugins activated together |
| `activeByDefault` | Turns on unless another profile selection replaces the default set |
| `-Pprod` | Activate the `prod` profile from the command line |
| Property such as `app.env` | Value that resources or docs can document per environment |

| Question | Your answer           |
| -------- |-----------------------|
| Which profile is active when you run plain `mvn package`? | dev                   |
| How do you activate `prod` on the command line? | mvn -Prod packagename |
| What is the `app.env` value under `dev`? | dev                   |
| What is the `app.env` value under `prod`? | prod                  |

Spot the mistakes
Explain why each is dangerous:

putting production database passwords inside the dev profile;
- could expose or accidentally use production credentials
making prod activeByDefault on every engineer laptop;
- could accidentally use production configuration or services.
assuming profiles change Java package names (they do not — they change build/config properties);
- profiles control plugins, properties. they do not change the java package
documenting secrets in screenshots of profile properties.
Screenshots can be uploaded, shared, or committed and expose credentials.
  Keep `dev` as the laptop default.
  Activate `prod` intentionally with `-Pprod`.
  Never store real production secrets in `pom.xml` profiles.
  | # | Confirm | Notes |
  | - | ------- | ----- |
  | 1 | Four Q&A rows match the reference | Pass  |
  | 2 | You flag at least two profile mistakes | Pass  |
  | 3 | Activation rule is written | Pass  |