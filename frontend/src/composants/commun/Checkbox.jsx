import React from 'react';
import { Check } from 'lucide-react';

const Checkbox = ({
  label,
  name,
  checked,
  onChange,
  error = '',
  required = false,
  className = ''
}) => {
  return (
    <div className={`flex flex-col gap-1 ${className}`}>
      <div className="flex items-start gap-2">
        <div className="relative flex items-center">
          <input
            id={name}
            name={name}
            type="checkbox"
            checked={checked}
            onChange={onChange}
            required={required}
            className="w-5 h-5 border-2 border-gray-300 rounded appearance-none cursor-pointer checked:bg-emerald-600 checked:border-emerald-600 focus:outline-none focus:ring-2 focus:ring-emerald-500 focus:ring-offset-2 transition-all"
          />
          {checked && (
            <Check size={14} className="absolute left-0.5 text-white pointer-events-none" strokeWidth={3} />
          )}
        </div>
        {label && (
          <label htmlFor={name} className="text-sm text-gray-700 cursor-pointer select-none">
            {label}
            {required && <span className="text-red-500 ml-1">*</span>}
          </label>
        )}
      </div>
      {error && <span className="text-xs text-red-500">{error}</span>}
    </div>
  );
};

export default Checkbox;
