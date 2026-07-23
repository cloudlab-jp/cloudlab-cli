{{imports}}

@ExtendWith(MockitoExtension.class)
class {{className}}ServiceTest {

    @Mock
    private {{className}}Repository repository;

    @Mock
    private {{className}}Mapper mapper;

    @InjectMocks
    private {{className}}Service service;

{{tests}}

}