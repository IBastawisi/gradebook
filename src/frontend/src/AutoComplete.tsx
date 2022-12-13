import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Autocomplete from '@mui/material/Autocomplete';
import { GridRenderEditCellParams, useGridApiContext } from '@mui/x-data-grid';

type Option = { id: string, name: string };
export default function IDSelect(props: GridRenderEditCellParams & { options: Option[] }) {

  const { id, value, field, options } = props;
  const apiRef = useGridApiContext();

  const handleValueChange = (event: any, option: any) => {
    const newValue = option?.id ?? value;
    apiRef.current.setEditCellValue({ id, field, value: newValue });
  };

  return (
    <Autocomplete
      sx={{ width: 300 }}
      size="small"
      options={options}
      value={options.find((option) => option.id === value) ?? null}
      onChange={handleValueChange}
      autoHighlight
      getOptionLabel={(option) => option.id}
      renderOption={(props, option) => (
        <Box component="li" sx={{ '& > img': { mr: 2, flexShrink: 0 } }} {...props}>
          ({option.id}) {option.name}
        </Box>
      )}
      renderInput={(params) => (
        <TextField
          {...params}
          inputProps={{
            ...params.inputProps,
          }}
        />
      )}
    />
  );
}