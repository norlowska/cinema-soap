import { localStorageService } from './localStorage.service';
import { notification } from 'antd';

export const userService = {
  logout,
};

function logout() {
  localStorageService.clearToken();
  notification.success({
    message: 'Sukces',
    description: 'Pomyślnie wylogowano z serwisu',
    placement: 'bottomRight',
    duration: 4,
  });
}
